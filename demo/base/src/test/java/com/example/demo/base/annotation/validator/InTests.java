package com.example.demo.base.annotation.validator;


import com.example.demo.base.annotation.validator.In;
import com.example.demo.base.utils.ValidatorUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
public class InTests {

    @ParameterizedTest
    @MethodSource("inTest")
    public void inTest(Tester tester, int size) {
        Map<String, List<String>> errors = ValidatorUtils.validate(tester);

        Assertions.assertEquals(errors.size(), size, "结果不一致");
    }

    private static Stream<Arguments> inTest() {
        return Stream.of(
                Arguments.arguments(Tester.builder().string("a").build(), 0),
                Arguments.arguments(Tester.builder().string("c").build(), 1),
                Arguments.arguments(Tester.builder().integer(1).build(), 0),
                Arguments.arguments(Tester.builder().integer(3).build(), 1),
                Arguments.arguments(Tester.builder().bool(true).build(), 0),
                Arguments.arguments(Tester.builder().bool(null).build(), 0)
        );
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Tester {
        @In(allows = {"a", "b"})
        private String string;
        @In(allows = {"1", "2"})
        private Integer integer;
        @In(allows = {"true", "false"})
        private Boolean bool;
    }
}
