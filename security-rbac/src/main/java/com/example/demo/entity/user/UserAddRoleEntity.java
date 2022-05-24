package com.example.demo.entity.user;

import com.alibaba.cola.domain.Entity;
import com.example.demo.dao.UserRoleDaoImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Where.LIU
 * @since 2022/5/24
 */
@Data
@Entity
public class UserAddRoleEntity {
    private final UserRoleDaoImpl userRoleDao;

    private Long userId;
    private List<Long> roleIds;

    @Autowired
    public UserAddRoleEntity(UserRoleDaoImpl userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    public void add() {
        userRoleDao.userAddRoles(this.userId, this.roleIds);
    }
}
