package com.example.demo.utils;


import javax.validation.*;
import java.util.*;

public class ValidatorUtils {
    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> Map<String, List<String>> validate(T bean, Class<?>... groups) throws ValidationException {
        Set<ConstraintViolation<T>> constraintViolations = VALIDATOR.validate(bean, groups);
        Map<String, List<String>> errors = new HashMap<>();
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            String field = constraintViolation.getPropertyPath().toString();
            errors.computeIfAbsent(field, key -> new ArrayList<>()).add(constraintViolation.getMessage());
        }
        return errors;
    }
}
