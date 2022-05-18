package com.example.demo.converter;

import com.example.demo.dataobject.UserDO;
import com.example.demo.entity.UserEntity;
import org.mapstruct.Mapper;

/**
 * @author Where.LIU
 * @since 2022/5/18
 */
@Mapper(componentModel = "spring")
public interface UserConverter {
    /**
     * 数据库模型转为实体模型
     *
     * @param source 数据库模型
     * @return 实体模型
     */
    UserEntity of(UserDO source);
}
