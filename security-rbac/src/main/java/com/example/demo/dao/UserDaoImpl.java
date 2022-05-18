package com.example.demo.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.constants.Constant;
import com.example.demo.dataobject.UserDO;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Service
public class UserDaoImpl extends ServiceImpl<UserMapper, UserDO>
        implements IService<UserDO> {
    public UserDO getByUsername(String username) {
        if (Objects.isNull(username)) {
            return null;
        }
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserDO::getUsername, username);
        queryWrapper.last(Constant.LIMIT_ONE);
        return getOne(queryWrapper);
    }
}
