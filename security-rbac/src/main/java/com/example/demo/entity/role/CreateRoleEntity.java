package com.example.demo.entity.role;

import com.alibaba.cola.domain.Entity;
import com.example.demo.converter.RoleConverter;
import com.example.demo.dao.RoleDaoImpl;
import com.example.demo.dataobject.RoleDO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Data
@Entity
public class CreateRoleEntity {
    private final RoleConverter roleConverter;
    private final RoleDaoImpl roleDao;

    private Long id;
    private Long pid;
    private String name;

    @Autowired
    public CreateRoleEntity(RoleConverter roleConverter, RoleDaoImpl roleDao) {
        this.roleConverter = roleConverter;
        this.roleDao = roleDao;
    }

    public void save() {
        RoleDO roleDO = roleConverter.of(this);
        boolean result = roleDao.save(roleDO);
        if (result) {
            this.id = roleDO.getId();
        }
    }
}
