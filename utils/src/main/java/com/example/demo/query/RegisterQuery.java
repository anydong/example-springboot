package com.example.demo.query;

import com.example.demo.annotation.validator.Equals;
import com.example.demo.annotation.validator.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Equals(properties = {"password", "passwordConfirmation"})
public class RegisterQuery {
    public String username;
    private String password;
    private String passwordConfirmation;
    @In(allows = {"1", "2"})
    @NotNull
    private Integer sex;
}
