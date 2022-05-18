package com.example.demo.service;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
public class AuthenticationDetailsSourceImpl
        implements AuthenticationDetailsSource<HttpServletRequest, UserDetails> {
    @Override
    public UserDetails buildDetails(HttpServletRequest context) {
        return null;
    }
}
