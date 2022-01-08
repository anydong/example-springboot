package com.example.demo.infrastructure.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.base.constants.MybatisPlusConstants;
import com.example.demo.infrastructure.mapper.UserMapper;
import com.example.demo.infrastructure.po.UserPO;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public class UserDaoImpl extends ServiceImpl<UserMapper, UserPO> implements IService<UserPO> {
    public UserPO getByUsername(String username) {
        LambdaQueryWrapper<UserPO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserPO::getUsername, username);
        queryWrapper.last(MybatisPlusConstants.LIMIT_ONE);
        return baseMapper.selectOne(queryWrapper);
    }
}
