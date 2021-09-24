package com.example.demo.exception;

import com.example.demo.ResponseResult;
import com.example.demo.ValidationResult;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
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
     * @return CustomResponseResult
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseResult bindExceptionHandler(BindException e) {
        ValidationResult ValidationResult = new ValidationResult(false);
        for (FieldError error : e.getFieldErrors()) {
            ValidationResult.addError(error.getField(), error.getDefaultMessage());
        }
        return ResponseResult.invalidInput(ValidationResult.getErrors());
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
     *
     * @param e ConstraintViolationException
     * @return CustomResponseResult
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseResult constraintViolationExceptionHandler(ConstraintViolationException e) {
        ValidationResult ValidationResult = new ValidationResult(false);
        e.getConstraintViolations().forEach(constraintViolation -> {
            String field = constraintViolation.getPropertyPath().toString();
            ValidationResult.addError(field, constraintViolation.getMessage());
        });
        return ResponseResult.invalidInput(ValidationResult.getErrors());
    }

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常
     *
     * @param e MethodArgumentNotValidException
     * @return CustomResponseResult
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ValidationResult ValidationResult = new ValidationResult(false);
        for (FieldError error : e.getFieldErrors()) {
            ValidationResult.addError(error.getField(), error.getDefaultMessage());
        }
        return ResponseResult.invalidInput(ValidationResult.getErrors());
    }

    /**
     * 处理请求参数格式错误 @RequestBody JSON 解析错误时抛出
     *
     * @param e HttpMessageNotReadableException
     * @return CustomResponseResult
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseResult httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        ValidationResult ValidationResult = new ValidationResult(false);
        if (e.getCause() instanceof InvalidFormatException) {
            InvalidFormatException invalidFormatException = (InvalidFormatException) e.getCause();
            List<JsonMappingException.Reference> references = invalidFormatException.getPath();
            for (JsonMappingException.Reference reference : references) {
                ValidationResult.addError(reference.getFieldName(), invalidFormatException.getOriginalMessage());
            }
        }
        return ResponseResult.invalidInput(ValidationResult.getErrors());
    }
}
