package com.example.demo.annotation.validator;

import com.example.demo.query.RegisterQuery;
import com.example.demo.utils.ValidatorUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
public class EqualsTests {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void equalsTest() throws JsonProcessingException {
        RegisterQuery query = new RegisterQuery();
        query.setPassword("123456");
        query.setPasswordConfirmation("12345");

        Map<String, List<String>> errors = ValidatorUtils.validate(query);
        log.info(objectMapper.writeValueAsString(errors));
        Assert.isTrue(errors.size() == 1, "仅有 1 个错误");
    }
}
