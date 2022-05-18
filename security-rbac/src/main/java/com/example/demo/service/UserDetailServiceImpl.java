package com.example.demo.service;

import com.example.demo.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Where.LIU
 * @since 2022/5/17
 */
@Component
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (null == username) {
            return null;
        }
        log.info("username {}", username);
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword("$2a$10$WY1Vj02xFV80vthExkNywOlWm5HjZlWDluCNmDR2peJkbgDVW3bQS");
        return userEntity;
    }
}
