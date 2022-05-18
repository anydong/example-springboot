package com.example.demo.security;

import com.example.demo.RequestWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StreamUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        RequestWrapper wrapper = new RequestWrapper((HttpServletRequest) request);

        super.doFilter(wrapper, response, chain);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        RequestWrapper wrapper = (RequestWrapper) request;

//Get the input stream from the wrapper and convert it into byte array
        byte[] body = StreamUtils.copyToByteArray(wrapper.getInputStream());

// use jackson ObjectMapper to convert the byte array to Map (represents JSON)
        Map<String, Object> jsonRequest = new ObjectMapper().readValue(body, Map.class);
        log.info("aaaa {}", jsonRequest);

        log.info("step 2");
        return this.getAuthenticationManager().authenticate(new LoginAuthentication());
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
