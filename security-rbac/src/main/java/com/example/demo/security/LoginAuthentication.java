package com.example.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Where.LIU
 * @since 2022/5/17
 */
public class LoginAuthentication implements Authentication {
    /**
     * username
     */
    private String principal;
    /**
     * password
     */
    private String credentials;
    /**
     * 是否通过验证
     */
    private boolean authenticated = false;
    /**
     * 用户详情
     */
    private UserDetails details;
    /**
     * 用户拥有的权限
     */
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getDetails() {
        return this.details;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return null != this.details ? this.details.getUsername() : null;
    }
}
