package com.example.demo.annotation.validator;

import com.example.demo.query.RegisterQuery;
import com.example.demo.utils.ValidatorUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class InTests {
    @Autowired
    private ObjectMapper objectMapper;

    @ParameterizedTest
    @MethodSource("inTest")
    public void inTest(RegisterQuery query, int size) throws JsonProcessingException {
        Map<String, List<String>> errors = ValidatorUtils.validate(query);
        log.info(objectMapper.writeValueAsString(errors));
        Assert.isTrue(errors.size() == size, "结果不一致");
    }

    private static Stream<Arguments> inTest() {
        return Stream.of(
                Arguments.arguments(RegisterQuery.builder().sex(1).build(), 0),
                Arguments.arguments(RegisterQuery.builder().sex(3).build(), 1)
        );
    }
}
