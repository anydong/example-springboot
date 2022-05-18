package com.example.demo.entity.user;

import com.alibaba.cola.domain.Entity;
import com.example.demo.converter.UserConverter;
import com.example.demo.dao.UserDaoImpl;
import com.example.demo.dataobject.UserDO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Entity
@Data
public class CreateUserEntity {
    private final UserConverter userConverter;
    private final UserDaoImpl userDao;

    private Long id;
    private String username;
    @JsonIgnore
    private String password;

    @Autowired
    public CreateUserEntity(UserConverter userConverter, UserDaoImpl userDao) {
        this.userConverter = userConverter;
        this.userDao = userDao;
    }

    public void save() {
        UserDO userDO = userConverter.of(this);
        boolean result = userDao.save(userDO);
        if (result) {
            this.id = userDO.getId();
        }
    }
}
