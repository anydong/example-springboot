package com.example.demo.infrastructure.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.base.constants.MybatisPlusConstants;
import com.example.demo.infrastructure.mapper.UserTokenMapper;
import com.example.demo.infrastructure.po.UserTokenPO;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * @author where
 */
@Service
public class UserTokenDaoImpl extends ServiceImpl<UserTokenMapper, UserTokenPO> implements IService<UserTokenPO> {
    @Nullable
    public UserTokenPO getByToken(String token) {
        LambdaQueryWrapper<UserTokenPO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserTokenPO::getToken, token);
        queryWrapper.last(MybatisPlusConstants.LIMIT_ONE);
        return baseMapper.selectOne(queryWrapper);
    }
}
