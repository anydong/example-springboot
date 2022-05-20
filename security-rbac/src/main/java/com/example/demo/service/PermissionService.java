package com.example.demo.service;

import com.example.demo.converter.PermissionConverter;
import com.example.demo.dao.PermissionDaoImpl;
import com.example.demo.dataobject.PermissionDO;
import com.example.demo.entity.permission.PermissionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Service
public class PermissionService {
    private final PermissionConverter permissionConverter;
    private final PermissionDaoImpl permissionDao;

    @Autowired
    public PermissionService(PermissionConverter permissionConverter,
                             PermissionDaoImpl permissionDao) {
        this.permissionConverter = permissionConverter;
        this.permissionDao = permissionDao;
    }

    public Optional<PermissionEntity> getByPermissionId(Long permissionId) {
        PermissionDO permissionDO = permissionDao.getById(permissionId);
        return Optional.ofNullable(permissionDO)
                .map(permissionConverter::of);
    }

    /**
     * 递归获取所有的权限
     *
     * @param permissionId 父 ID
     * @return 权限树
     */
    public Optional<PermissionEntity> getWithChildrenByPermissionId(Long permissionId) {
        return this.getByPermissionId(permissionId)
                .map(permissionEntity -> {
                    List<PermissionEntity> children = this.listWithChildrenByPid(permissionId);
                    permissionEntity.setChildren(children);
                    return permissionEntity;
                });
    }

    public List<PermissionEntity> listByPid(Long pid) {
        return permissionDao.listByPid(pid).stream()
                .map(permissionConverter::of)
                .toList();
    }

    /**
     * 递归获取所有的权限
     *
     * @param pid 父 ID
     * @return 权限树
     */
    public List<PermissionEntity> listWithChildrenByPid(Long pid) {
        List<PermissionEntity> permissionEntityList = this.listByPid(pid);
        for (PermissionEntity permissionEntity : permissionEntityList) {
            List<PermissionEntity> permissionEntityChildren = this.listWithChildrenByPid(permissionEntity.getId());
            permissionEntity.setChildren(permissionEntityChildren);
        }
        return permissionEntityList;
    }
}
