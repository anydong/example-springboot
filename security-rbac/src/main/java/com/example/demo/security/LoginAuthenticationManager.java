package com.example.demo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Where.LIU
 * @since 2022/5/17
 */
@Component
@Slf4j
public class LoginAuthenticationManager implements AuthenticationManager {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginAuthenticationManager(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (!supports(authentication.getClass())) {
            return null;
        }
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        UserDetails userDetails = (UserDetails) authentication.getDetails();
        if (null == password || null == userDetails || !passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password.");
        }
        LoginAuthentication loginAuthentication = new LoginAuthentication(username, password, userDetails, true);
        log.info("{}", loginAuthentication);

        return loginAuthentication;
    }

    private boolean supports(Class<?> authentication) {
        return null != authentication && authentication.isAssignableFrom(LoginAuthentication.class);
    }
}
