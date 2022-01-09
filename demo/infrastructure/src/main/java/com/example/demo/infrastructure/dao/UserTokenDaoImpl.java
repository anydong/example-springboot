package com.example.demo.infrastructure.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.infrastructure.mapper.UserTokenMapper;
import com.example.demo.infrastructure.po.UserTokenPO;
import org.springframework.stereotype.Service;

/**
 * @author where
 */
@Service
public class UserTokenDaoImpl extends ServiceImpl<UserTokenMapper, UserTokenPO> implements IService<UserTokenPO> {
}
