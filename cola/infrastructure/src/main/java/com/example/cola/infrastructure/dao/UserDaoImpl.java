package com.example.cola.infrastructure.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cola.infrastructure.mapper.UserMapper;
import com.example.cola.infrastructure.po.UserPO;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public class UserDaoImpl extends ServiceImpl<UserMapper, UserPO> implements IService<UserPO> {

}
