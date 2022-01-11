package com.example.demo.base.annotation.validator;

import com.example.demo.base.annotation.validator.Equals;
import com.example.demo.base.annotation.validator.In;
import com.example.demo.base.utils.ValidatorUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;


@Slf4j
public class EqualsTests {
    @Test
    public void equalsTest() {
        Tester tester = new Tester();
        tester.setSex(1);
        tester.setPassword("123456");
        tester.setPasswordConfirmation("12345");

        Map<String, List<String>> errors = ValidatorUtils.validate(tester);
        Assertions.assertEquals(1, errors.size(), "仅有 1 个错误");
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Equals(properties = {"password", "passwordConfirmation"})
    public static class Tester {
        public String username;
        private String password;
        private String passwordConfirmation;
        @In(allows = {"1", "2"})
        @NotNull
        private Integer sex;
    }
}
