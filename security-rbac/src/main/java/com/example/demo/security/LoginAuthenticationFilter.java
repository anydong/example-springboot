package com.example.demo.security;

import com.example.demo.util.HttpRequestWrapper;
import com.example.demo.util.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Where.LIU
 * @since 2022/5/17
 */
@Slf4j
public class LoginAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private static final AntPathRequestMatcher PATH_REQUEST_MATCHER = new AntPathRequestMatcher("/auth/login");

    public LoginAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(PATH_REQUEST_MATCHER, authenticationManager);
    }

    public LoginAuthenticationFilter(RequestMatcher requestMatcher, AuthenticationManager authenticationManager) {
        super(requestMatcher, authenticationManager);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpRequestWrapper wrapper = new HttpRequestWrapper((HttpServletRequest) request);
        super.doFilter(wrapper, response, chain);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        HttpRequestWrapper wrapper = (HttpRequestWrapper) request;
        JsonNode body = JSONUtil.MAPPER.readTree(wrapper.getInputStream());
        String username = obtainUsername(body);
        String password = obtainPassword(body);
        UserDetails userDetails = (UserDetails) this.authenticationDetailsSource.buildDetails(wrapper);
        Authentication authentication = new LoginAuthentication(username, password, userDetails);

        log.info("authentication {}", authentication);

        return this.getAuthenticationManager().authenticate(authentication);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }

    private String obtainUsername(JsonNode body) {
        try {
            return body.get("username").asText();
        } catch (Exception e) {
            return null;
        }
    }

    private String obtainPassword(JsonNode body) {
        try {
            return body.get("password").asText();
        } catch (Exception e) {
            return null;
        }
    }
}
