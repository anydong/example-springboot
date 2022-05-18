package com.example.demo.service;

import com.example.demo.converter.PermissionConverter;
import com.example.demo.dao.PermissionDaoImpl;
import com.example.demo.dataobject.PermissionDO;
import com.example.demo.entity.permission.PermissionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public PermissionEntity getByPermissionId(Long permissionId) {
        PermissionDO permissionDO = permissionDao.getById(permissionId);
        return Optional.ofNullable(permissionDO)
                .map(permissionConverter::of)
                .orElse(null);
    }
}
