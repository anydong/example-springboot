package com.example.demo.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dataobject.RolePermissionDO;
import com.example.demo.mapper.RolePermissionMapper;
import org.springframework.stereotype.Service;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Service
public class RolePermissionDaoImpl extends ServiceImpl<RolePermissionMapper, RolePermissionDO>
        implements IService<RolePermissionDO> {
}
