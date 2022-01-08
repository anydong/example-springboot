package com.example.demo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author where
 */
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
@Getter
@AllArgsConstructor
public enum BizExceptionEnums {
    /**
     * 正确执行后的返回
     */
    OK("00000", "一切 OK"),
    /**
     * 一级宏观错误码
     */
    USER_CLIENT_ERROR("A0001","用户端错误"),
    /**
     * 二级宏观错误码
     */
    USER_REGISTER_FAILURE("A0100","用户注册错误"),
    USERNAME_IS_EXISTS("A0111", "用户名已存在"),
    ;
    /**
     * 错误码
     */
    private final String errCode;
    /**
     * 中文描述
     */
    private final String errMessage;
}
