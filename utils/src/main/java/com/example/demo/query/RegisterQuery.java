package com.example.demo.query;

import com.example.demo.annotation.validator.Equals;
import lombok.Data;

@Data
@Equals(properties = {"password", "passwordConfirmation"})
public class RegisterQuery {
    public String username;
    private String password;
    private String passwordConfirmation;
}
