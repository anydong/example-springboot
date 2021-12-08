package com.example.demo.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dataobject.UserDO;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public class UserDaoImpl extends ServiceImpl<UserMapper, UserDO> implements BaseDaoI<UserDO> {
}
