package com.example.demo.entity.permission;

import com.alibaba.cola.domain.Entity;
import com.example.demo.converter.PermissionConverter;
import com.example.demo.dao.PermissionDaoImpl;
import com.example.demo.dataobject.PermissionDO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Entity
@Data
public class CreatePermissionEntity {
    private final PermissionConverter permissionConverter;
    private final PermissionDaoImpl permissionDao;

    private Long id;
    private Long pid;
    private String oid;
    private String name;
    private String path;
    private String method;

    @Autowired
    public CreatePermissionEntity(PermissionConverter permissionConverter,
                                  PermissionDaoImpl permissionDao) {
        this.permissionConverter = permissionConverter;
        this.permissionDao = permissionDao;
    }

    public void save() {
        PermissionDO permissionDO = permissionConverter.of(this);
        boolean result = permissionDao.save(permissionDO);
        if (result) {
            this.id = permissionDO.getId();
        }
    }
}
