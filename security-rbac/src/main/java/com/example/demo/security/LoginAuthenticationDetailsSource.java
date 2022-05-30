package com.example.demo.security;

import com.example.demo.util.HttpRequestWrapper;
import com.example.demo.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Component
@Slf4j
public class LoginAuthenticationDetailsSource
        implements AuthenticationDetailsSource<HttpServletRequest, UserDetails> {
    private final UserDetailsService userDetailsService;

    @Autowired
    public LoginAuthenticationDetailsSource(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public UserDetails buildDetails(HttpServletRequest context) {
        HttpRequestWrapper httpRequestWrapper = (HttpRequestWrapper) context;
        try {
            JsonNode body = JSONUtil.MAPPER.readTree(httpRequestWrapper.getInputStream());
            String username = obtainUsername(body);
            return userDetailsService.loadUserByUsername(username);
        } catch (IOException e) {
            log.error("从 body 中解析 username 出错", e);
        }
        return null;
    }

    private String obtainUsername(JsonNode body) {
        try {
            return body.get("username").asText();
        } catch (Exception e) {
            return null;
        }
    }
}
