package com.example.demo.convertor;

import com.example.demo.domain.auth.request.UsernameLoginQry;
import com.example.demo.model.request.UsernameLoginCmd;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsernameLoginQryConvertor {
    UsernameLoginQry of(UsernameLoginCmd source);
}
