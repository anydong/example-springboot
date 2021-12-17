package com.example.infrastructure.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.infrastructure.mapper.UserMapper;
import com.example.infrastructure.po.UserPO;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl extends ServiceImpl<UserMapper, UserPO> implements IService<UserPO> {

}
