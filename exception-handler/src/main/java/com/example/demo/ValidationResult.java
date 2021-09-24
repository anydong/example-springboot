package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationResult {
    private final Boolean valid;
    @Getter
    @Setter
    private Map<String, List<String>> errors;

    public ValidationResult(Boolean valid) {
        this.valid = valid;
        this.errors = new HashMap<>();
    }

    public Boolean isValid() {
        return this.valid;
    }

    public Boolean isInvalid() {
        return !this.valid;
    }

    public void addError(String field, String message) {
        List<String> messages = this.errors.getOrDefault(field, new ArrayList<>());
        messages.add(message);
        this.errors.put(field, messages);
    }

    public String toString() {
        return JSON.toJSONString(this.errors);
    }
}
