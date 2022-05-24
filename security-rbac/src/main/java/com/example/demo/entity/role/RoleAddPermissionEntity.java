package com.example.demo.entity.role;

import com.alibaba.cola.domain.Entity;
import com.example.demo.dao.RolePermissionDaoImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Where.LIU
 * @since 2022/5/24
 */
@Data
@Entity
public class RoleAddPermissionEntity {
    private final RolePermissionDaoImpl rolePermissionDao;

    private Long roleId;
    private List<Long> permissionIds;

    @Autowired
    public RoleAddPermissionEntity(RolePermissionDaoImpl rolePermissionDao) {
        this.rolePermissionDao = rolePermissionDao;
    }

    public void add() {
        this.rolePermissionDao.roleAddPermissions(this.roleId, permissionIds);
    }
}
