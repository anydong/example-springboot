package com.example.demo.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dataobject.UserRoleDO;
import com.example.demo.mapper.UserRoleMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Service
public class UserRoleDaoImpl extends ServiceImpl<UserRoleMapper, UserRoleDO>
        implements IService<UserRoleDO> {

    public void roleAddUsers(Long roleId, List<Long> userIds) {
        if (CollectionUtils.isEmpty(userIds)) {
            return;
        }
        List<UserRoleDO> userRoleDOList = userIds.stream()
                .map(userId -> {
                    UserRoleDO userRoleDO = new UserRoleDO();
                    userRoleDO.setUserId(userId);
                    userRoleDO.setRoleId(roleId);
                    return userRoleDO;
                })
                .toList();
        saveBatch(userRoleDOList);
    }

    public void userAddRoles(Long userId, List<Long> roleIds) {
        if (CollectionUtils.isEmpty(roleIds)) {
            return;
        }
        List<UserRoleDO> userRoleDOList = roleIds.stream()
                .map(roleId -> {
                    UserRoleDO userRoleDO = new UserRoleDO();
                    userRoleDO.setUserId(userId);
                    userRoleDO.setRoleId(roleId);
                    return userRoleDO;
                })
                .toList();
        saveBatch(userRoleDOList);
    }
}
