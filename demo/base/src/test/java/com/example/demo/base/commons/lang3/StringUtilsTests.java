package com.example.demo.base.commons.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.util.Assert;

import java.util.stream.Stream;

@Slf4j
public class StringUtilsTests {
    @ParameterizedTest
    @MethodSource("isBlank")
    public void isBlank(String str, Boolean expect) {
        log.info("isBlank {} : {}", str, StringUtils.isBlank(str));
        Assert.isTrue(expect.equals(StringUtils.isBlank(str)), "结果不一致");
    }

    private static Stream<Arguments> isBlank() {
        return Stream.of(
                Arguments.arguments(null, true),
                Arguments.arguments("", true),
                Arguments.arguments(" ", true),
                Arguments.arguments("a", false),
                Arguments.arguments(" a", false),
                Arguments.arguments(" a ", false)
        );
    }

    @ParameterizedTest
    @MethodSource("isEmpty")
    public void isEmpty(String str, Boolean expect) {
        log.info("isEmpty {} : {}", str, StringUtils.isEmpty(str));
        Assert.isTrue(expect.equals(StringUtils.isEmpty(str)), "结果不一致");
    }

    private static Stream<Arguments> isEmpty() {
        return Stream.of(
                Arguments.arguments(null, true),
                Arguments.arguments("", true),
                Arguments.arguments(" ", false),
                Arguments.arguments("a", false),
                Arguments.arguments(" a", false)
        );
    }
}
