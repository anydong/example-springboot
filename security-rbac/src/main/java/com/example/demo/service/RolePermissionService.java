package com.example.demo.service;

import com.example.demo.dao.RolePermissionDaoImpl;
import com.example.demo.dataobject.RolePermissionDO;
import com.example.demo.entity.permission.PermissionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Service
public class RolePermissionService {
    private final RolePermissionDaoImpl rolePermissionDao;
    private final PermissionService permissionService;

    @Autowired
    public RolePermissionService(RolePermissionDaoImpl rolePermissionDao,
                                 PermissionService permissionService) {
        this.rolePermissionDao = rolePermissionDao;
        this.permissionService = permissionService;
    }

    public List<PermissionEntity> listPermissions(Long roleId) {
        if (Objects.isNull(roleId)) {
            return Collections.emptyList();
        }
        List<RolePermissionDO> rolePermissionDOList = rolePermissionDao.listByRoleId(roleId);
        List<PermissionEntity> permissionEntityList = rolePermissionDOList.stream()
                .filter(Objects::nonNull)
                .map(RolePermissionDO::getPermissionId)
                .map(permissionService::getByPermissionId)
                .filter(Objects::nonNull)
                .toList();
        return permissionEntityList;
    }
}
