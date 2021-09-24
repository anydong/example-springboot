package com.example.demo.exception;

import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateException extends Exception {
    @Getter
    private final Map<String, List<String>> errors;

    public ValidateException(String field, String message) {
        errors = new HashMap<>();
        errors.put(field, Collections.singletonList(message));
    }
}
