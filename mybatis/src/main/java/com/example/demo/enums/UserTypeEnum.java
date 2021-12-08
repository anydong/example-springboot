package com.example.demo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserTypeEnum {
    /**
     * 用户类型：用户
     */
    USER(1, "user"),
    /**
     * 用户类型：管理员
     */
    ADMIN(2, "admin"),
    ;
    @EnumValue
    @JsonValue
    private final Integer value;
    private final String name;
}
