package com.example.demo.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dataobject.RolePermissionDO;
import com.example.demo.mapper.RolePermissionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Service
public class RolePermissionDaoImpl extends ServiceImpl<RolePermissionMapper, RolePermissionDO>
        implements IService<RolePermissionDO> {

    /**
     * 根据角色 ID 获取关联权限
     *
     * @param roleId 角色 ID
     * @return 角色关联权限
     */
    public List<RolePermissionDO> listByRoleId(Long roleId) {
        LambdaQueryWrapper<RolePermissionDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(RolePermissionDO::getRoleId, roleId);
        return list(queryWrapper);
    }
}
