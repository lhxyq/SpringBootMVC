package com.lh.web.util.security;

import com.lh.web.domain.User;
import com.lh.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by LH 2446059046@qq.com on 2017/7/17.
 */

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        try {
            user = userService.findByName(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("spring security framework exception");
        }

        if (null == user)
            throw new UsernameNotFoundException("用户不存在");

        return new UserDetail(user);
    }
}
