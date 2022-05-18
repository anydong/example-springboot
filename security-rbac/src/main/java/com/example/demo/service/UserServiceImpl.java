package com.example.demo.service;

import com.example.demo.converter.UserConverter;
import com.example.demo.dataobject.UserDO;
import com.example.demo.entity.UserEntity;
import com.example.demo.dao.UserDaoImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl implements UserDetailsService {
    private final UserConverter userConverter;
    private final UserDaoImpl userDao;

    @Autowired
    public UserServiceImpl(UserConverter userConverter, UserDaoImpl userDao) {
        this.userConverter = userConverter;
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (null == username) {
            return null;
        }
        UserDO userDO = userDao.getByUsername(username);
        return userConverter.of(userDO);
    }
}
