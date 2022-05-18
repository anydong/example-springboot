package com.example.demo.converter;

import com.example.demo.dataobject.RoleDO;
import com.example.demo.entity.role.CreateRoleEntity;
import com.example.demo.entity.role.RoleEntity;
import org.mapstruct.Mapper;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Mapper(componentModel = "spring")
public interface RoleConverter {
    /**
     * 创建数据库模型
     *
     * @param source 创建实体
     * @return 数据库模型
     */
    RoleDO of(CreateRoleEntity source);

    RoleEntity of(RoleDO source);
}
