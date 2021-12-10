package com.example.demo.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dataobject.UserDO;
import com.example.demo.mapper.UserMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public class UserDaoImpl extends ServiceImpl<UserMapper, UserDO> implements BaseDaoI<UserDO> {
    public UserDO getLastOne() {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.orderByDesc(UserDO::getId);
        queryWrapper.last("LIMIT 1");
        return getOne(queryWrapper);
    }

    public UserDO createRandomOne() {
        UserDO userDO = new UserDO();
        userDO.setUsername(RandomStringUtils.random(8));
        userDO.setPassword(RandomStringUtils.random(16));
        save(userDO);
        return userDO;
    }
}
