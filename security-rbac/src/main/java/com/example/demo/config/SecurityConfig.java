package com.example.demo.config;

import com.example.demo.security.*;
import com.example.demo.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Where.LIU
 * @since 2022/5/17
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final AuthenticationSuccessHandler loginAuthenticationSuccessHandler;
    private final AuthenticationFailureHandler loginAuthenticationFailureHandler;
    private final AuthenticationManager loginAuthenticationManager;
    private final AuthenticationDetailsSource<HttpServletRequest, ?> loginAuthenticationDetailsSource;

    @Autowired
    public SecurityConfig(@Qualifier("loginAuthenticationSuccessHandler") AuthenticationSuccessHandler loginAuthenticationSuccessHandler,
                          @Qualifier("loginAuthenticationFailureHandler") AuthenticationFailureHandler loginAuthenticationFailureHandler,
                          @Qualifier("loginAuthenticationManager") AuthenticationManager loginAuthenticationManager,
                          @Qualifier("loginAuthenticationDetailsSource") AuthenticationDetailsSource<HttpServletRequest, ?> loginAuthenticationDetailsSource) {
        this.loginAuthenticationSuccessHandler = loginAuthenticationSuccessHandler;
        this.loginAuthenticationFailureHandler = loginAuthenticationFailureHandler;
        this.loginAuthenticationManager = loginAuthenticationManager;
        this.loginAuthenticationDetailsSource = loginAuthenticationDetailsSource;
    }


    private LoginAuthenticationFilter loginAuthenticationFilter() {
        RequestMatcher requestMatcher = new AntPathRequestMatcher("/auth/login", "POST");
        LoginAuthenticationFilter filter = new LoginAuthenticationFilter(requestMatcher, loginAuthenticationManager);
        filter.setAuthenticationFailureHandler(loginAuthenticationFailureHandler);
        filter.setAuthenticationSuccessHandler(loginAuthenticationSuccessHandler);
        filter.setAuthenticationDetailsSource(loginAuthenticationDetailsSource);
        return filter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().disable();
        http.csrf().disable();
        http.addFilterBefore(loginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests().anyRequest().authenticated();
        http.authorizeRequests().antMatchers("/index").permitAll();
    }
}
