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
import java.util.stream.Collectors;

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

    public List<RoleEntity> listRoleByPid(Long pid) {
        return roleDao.listRoleByPid(pid).stream()
                .map(roleConverter::of)
                .peek(roleEntity -> {
                    List<PermissionEntity> permissionEntityList = rolePermissionService.listPermissions(roleEntity.getId());
                    roleEntity.setPermissions(permissionEntityList);
                })
                .collect(Collectors.toList());
    }

    public List<RoleEntity> listRoleWithChildrenByPid(Long pid) {
        return roleDao.listRoleByPid(pid).stream()
                .map(roleConverter::of)
                .peek(roleEntity -> {
                    List<RoleEntity> children = this.listRoleWithChildrenByPid(roleEntity.getId());
                    roleEntity.setChildren(children);
                    List<PermissionEntity> permissionEntityList = rolePermissionService.listPermissions(roleEntity.getId());
                    roleEntity.setPermissions(permissionEntityList);
                })
                .collect(Collectors.toList());
    }

    public Optional<RoleEntity> getRoleWithChildren(Long roleId) {
        Optional<RoleEntity> roleEntityOptional = this.getRole(roleId);
        roleEntityOptional.ifPresent(roleEntity -> {
            List<RoleEntity> children = this.listRoleWithChildrenByPid(roleId);
            roleEntity.setChildren(children);
        });
        return roleEntityOptional;

    }
}
