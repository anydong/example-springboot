package com.example.demo.service;

import com.example.demo.converter.RoleConverter;
import com.example.demo.dao.RoleDaoImpl;
import com.example.demo.dataobject.RoleDO;
import com.example.demo.entity.permission.PermissionEntity;
import com.example.demo.entity.role.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Service
public class RoleService {
    private final RoleDaoImpl roleDao;
    private final RolePermissionService rolePermissionService;
    private final RoleConverter roleConverter;

    @Autowired
    public RoleService(RoleDaoImpl roleDao, RolePermissionService rolePermissionService,
                       RoleConverter roleConverter) {
        this.roleDao = roleDao;
        this.rolePermissionService = rolePermissionService;
        this.roleConverter = roleConverter;
    }

    public Optional<RoleEntity> getRole(Long roleId) {
        RoleDO roleDO = roleDao.getById(roleId);
        if (Objects.isNull(roleDO)) {
            return Optional.empty();
        }
        RoleEntity roleEntity = roleConverter.of(roleDO);
        List<PermissionEntity> permissionEntityList = rolePermissionService.listPermissions(roleId);
        roleEntity.setPermissions(permissionEntityList);

        return Optional.of(roleEntity);
    }
}
