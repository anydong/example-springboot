package com.example.demo.adapter.convertor;

import com.example.demo.adapter.model.request.UsernameLoginCmd;
import com.example.demo.domain.auth.request.UsernameLoginQry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsernameLoginQryConvertor {
    UsernameLoginQry of(UsernameLoginCmd source);
}
