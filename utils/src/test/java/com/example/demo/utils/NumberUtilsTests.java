package com.example.demo.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NumberUtilsTests {

    @ParameterizedTest
    @MethodSource(value = "isPositiveIntegerParams")
    public void isPositive(Integer value, boolean expect) {
        boolean result = NumberUtils.isPositive(value);
        Assertions.assertEquals(result, expect);
    }

    public static List<Arguments> isPositiveIntegerParams() {
        return Arrays.asList(
                Arguments.arguments(null, false),
                Arguments.arguments(0, false),
                Arguments.arguments(-1, false),
                Arguments.arguments(1, true)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "isPositiveLongParams")
    public void isPositive(Long value, boolean expect) {
        boolean result = NumberUtils.isPositive(value);
        Assertions.assertEquals(result, expect);
    }

    public static List<Arguments> isPositiveLongParams() {
        return Arrays.asList(
                Arguments.arguments(null, false),
                Arguments.arguments(0L, false),
                Arguments.arguments(-1L, false),
                Arguments.arguments(1L, true)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "isPositiveOrZeroIntegerParams")
    public void isPositiveOrZero(Integer value, boolean expect) {
        boolean result = NumberUtils.isPositiveOrZero(value);
        Assertions.assertEquals(result, expect);
    }

    public static List<Arguments> isPositiveOrZeroIntegerParams() {
        return Arrays.asList(
                Arguments.arguments(null, false),
                Arguments.arguments(-1, false),
                Arguments.arguments(0, true),
                Arguments.arguments(1, true)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "isNegativeIntegerParams")
    public void isNegative(Integer value, boolean expect) {
        boolean result = NumberUtils.isNegative(value);
        Assertions.assertEquals(result, expect);
    }

    public static List<Arguments> isNegativeIntegerParams() {
        return Arrays.asList(
                Arguments.arguments(null, false),
                Arguments.arguments(0, false),
                Arguments.arguments(1, false),
                Arguments.arguments(-1, true)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "isNegativeOrZeroIntegerParams")
    public void isNegativeOrZero(Integer value, boolean expect) {
        boolean result = NumberUtils.isNegativeOrZero(value);
        Assertions.assertEquals(result, expect);
    }

    public static List<Arguments> isNegativeOrZeroIntegerParams() {
        return Arrays.asList(
                Arguments.arguments(null, false),
                Arguments.arguments(1, false),
                Arguments.arguments(0, true),
                Arguments.arguments(-1, true)
        );
    }
}
