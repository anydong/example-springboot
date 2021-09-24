package com.example.demo;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult {
    private String code;
    private String message;
    private Object data;

    public ResponseResult(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    public static ResponseResult success(Object data) {
        ResponseResult responseResult = new ResponseResult(CodeEnum.SUCCESS);
        responseResult.setData(data);
        return responseResult;
    }

    public static ResponseResult invalidInput(Object data) {
        ResponseResult responseResult = new ResponseResult(CodeEnum.INVALID_INPUT);
        responseResult.setData(data);
        return responseResult;
    }

    @Getter
    @AllArgsConstructor
    public enum CodeEnum {
        SUCCESS("00000", "SUCCESS"),
        INVALID_INPUT("A0001", "Invalid input."),
        ;
        private String code;
        private String message;
    }

}
