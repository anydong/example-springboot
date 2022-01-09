package com.example.demo.advice;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.BizException;
import com.example.demo.common.response.ValidationResponse;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     *
     * @param e BindException
     * @return CustomResponseDto
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public ValidationResponse bindExceptionHandler(BindException e) {
        ValidationResponse response = ValidationResponse.buildFailure();
        for (FieldError error : e.getFieldErrors()) {
            response.addError(error.getField(), error.getDefaultMessage());
        }

        return response;
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
     *
     * @param e ConstraintViolationException
     * @return CustomResponseDto
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public Response constraintViolationExceptionHandler(ConstraintViolationException e) {
        ValidationResponse response = ValidationResponse.buildFailure();
        e.getConstraintViolations()
                .forEach(
                        constraintViolation -> {
                            String field = constraintViolation.getPropertyPath().toString();
                            response.addError(field, constraintViolation.getMessage());
                        });

        return response;
    }

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常
     *
     * @param e MethodArgumentNotValidException
     * @return CustomResponseDto
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public Response methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ValidationResponse response = ValidationResponse.buildFailure();
        for (FieldError error : e.getFieldErrors()) {
            response.addError(error.getField(), error.getDefaultMessage());
        }
        return response;
    }

    /**
     * 处理请求参数格式错误 @RequestBody JSON 解析错误时抛出
     *
     * @param e HttpMessageNotReadableException
     * @return CustomResponseDto
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public ValidationResponse httpMessageNotReadableExceptionHandler(
            HttpMessageNotReadableException e) {
        ValidationResponse response = ValidationResponse.buildFailure();
        if (e.getCause() instanceof InvalidFormatException) {
            InvalidFormatException invalidFormatException = (InvalidFormatException) e.getCause();
            List<JsonMappingException.Reference> references = invalidFormatException.getPath();
            for (JsonMappingException.Reference reference : references) {
                response.addError(
                        reference.getFieldName(), invalidFormatException.getOriginalMessage());
            }
        }

        return response;
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public Response httpMediaTypeNotSupportedExceptionHandler(
            HttpMediaTypeNotSupportedException e) {
        return ValidationResponse.buildFailure();
    }

    @ExceptionHandler(BizException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Response bizExceptionHandler(BizException e) {
        return Response.buildFailure(e.getErrCode(), e.getMessage());
    }
}
