package com.example.demo.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dataobject.RoleDO;
import com.example.demo.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Service
public class RoleDaoImpl extends ServiceImpl<RoleMapper, RoleDO>
        implements IService<RoleDO> {
}
