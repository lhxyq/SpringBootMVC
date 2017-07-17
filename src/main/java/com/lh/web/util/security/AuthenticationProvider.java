package com.lh.web.util.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by LH 2446059046@qq.com on 2017/7/17.
 */
@Component
public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {
    @Autowired
    private UserDetailService userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        UserDetail userDetail = (UserDetail) userDetailService.loadUserByUsername(username);

        if (null == userDetail)
            throw new BadCredentialsException("用户不存在");

        if (!passwordEncoder().encodePassword(password, "").equals(userDetail.getPassword()))
            throw new BadCredentialsException("密码错误");

        Collection<? extends GrantedAuthority> authorities = userDetail.getAuthorities();
        return new UsernamePasswordAuthenticationToken(userDetail, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    @Bean
    public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();
    }
}
