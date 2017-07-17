package com.lh.web.util.security;

import com.lh.web.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by LH 2446059046@qq.com on 2017/7/17.
 */
public class UserDetail implements UserDetails {
    private String name;
    private String eamil;
    private String password;
    private List<String> roles = new ArrayList<>();

    public UserDetail(User user) {
        this.name = user.getName();
        this.eamil = user.getEmail();
        this.password = user.getPassword();
        roles.add("ADMIN");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (null == roles || 0 > roles.size())
            return AuthorityUtils.commaSeparatedStringToAuthorityList("");

        StringBuilder rolesString = new StringBuilder();
        roles.forEach(role -> {
            rolesString.append(role).append(",");
        });

        String roleStr = rolesString.substring(0, rolesString.length() - 1);
        return AuthorityUtils.createAuthorityList(roleStr);

    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
