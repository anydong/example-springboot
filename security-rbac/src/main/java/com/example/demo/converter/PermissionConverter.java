package com.example.demo.converter;

import com.example.demo.dataobject.PermissionDO;
import com.example.demo.entity.permission.CreatePermissionEntity;
import com.example.demo.entity.permission.PermissionEntity;
import org.mapstruct.Mapper;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Mapper(componentModel = "spring")
public interface PermissionConverter {
    /**
     * 添加权限
     *
     * @param source 实体模型
     * @return 数据模型
     */
    PermissionDO of(CreatePermissionEntity source);

    /**
     * 数据库模型转为实体模型
     *
     * @param source 数据库模型
     * @return 实体模型
     */
    PermissionEntity of(PermissionDO source);
}
