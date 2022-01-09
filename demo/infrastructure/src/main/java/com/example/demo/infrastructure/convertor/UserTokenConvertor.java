package com.example.demo.infrastructure.convertor;

import com.example.demo.domain.dto.UserTokenDTO;
import com.example.demo.infrastructure.po.UserTokenPO;
import org.mapstruct.Mapper;

/**
 * @author where
 */
@Mapper(componentModel = "spring")
public interface UserTokenConvertor {
    UserTokenPO of(UserTokenDTO source);

    UserTokenDTO of(UserTokenPO userTokenPO);
}
