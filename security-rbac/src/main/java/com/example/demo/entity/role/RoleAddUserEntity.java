package com.example.demo.entity.role;

import com.alibaba.cola.domain.Entity;
import com.example.demo.dao.UserRoleDaoImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Where.LIU
 * @since 2022/5/24
 */
@Entity
@Data
public class RoleAddUserEntity {
    private final UserRoleDaoImpl userRoleDao;

    private Long roleId;
    private List<Long> userIds;

    @Autowired
    public RoleAddUserEntity(UserRoleDaoImpl userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    public void add() {
        userRoleDao.roleAddUsers(this.roleId, this.userIds);
    }
}
