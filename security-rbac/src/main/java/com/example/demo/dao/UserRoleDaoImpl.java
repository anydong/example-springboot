package com.example.demo.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dataobject.UserRoleDO;
import com.example.demo.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Service
public class UserRoleDaoImpl extends ServiceImpl<UserRoleMapper, UserRoleDO>
        implements IService<UserRoleDO> {
}
