package com.example.demo.utils;

import com.example.demo.annotation.validator.In;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntToLongFunction;

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
    @MethodSource(value = "isPositiveOrZeroLongParams")
    public void isPositiveOrZero(Long value, boolean expect) {
        boolean result = NumberUtils.isPositiveOrZero(value);
        Assertions.assertEquals(result, expect);
    }

    public static List<Arguments> isPositiveOrZeroLongParams() {
        return Arrays.asList(
                Arguments.arguments(null, false),
                Arguments.arguments(-1L, false),
                Arguments.arguments(0L, true),
                Arguments.arguments(1L, true)
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
    @MethodSource(value = "isNegativeLongParams")
    public void isNegative(Long value, boolean expect) {
        boolean result = NumberUtils.isNegative(value);
        Assertions.assertEquals(result, expect);
    }

    public static List<Arguments> isNegativeLongParams() {
        return Arrays.asList(
                Arguments.arguments(null, false),
                Arguments.arguments(0L, false),
                Arguments.arguments(1L, false),
                Arguments.arguments(-1L, true)
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

    @ParameterizedTest
    @MethodSource(value = "isNegativeOrZeroLongParams")
    public void isNegativeOrZero(Long value, boolean expect) {
        boolean result = NumberUtils.isNegativeOrZero(value);
        Assertions.assertEquals(result, expect);
    }

    public static List<Arguments> isNegativeOrZeroLongParams() {
        return Arrays.asList(
                Arguments.arguments(null, false),
                Arguments.arguments(1L, false),
                Arguments.arguments(0L, true),
                Arguments.arguments(-1L, true)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "ltIntegerParams")
    public void lt(Integer a, Integer b, boolean expect) {
        boolean result = NumberUtils.lt(a, b);
        Assertions.assertEquals(result, expect);
    }

    public static List<Arguments> ltIntegerParams() {
        return Arrays.asList(
                Arguments.arguments(null, null, false),
                Arguments.arguments(null, 1, false),
                Arguments.arguments(1, null, false),
                Arguments.arguments(1, 0, false),
                Arguments.arguments(1, 1, false),
                Arguments.arguments(1, -1, false),
                Arguments.arguments(1, 2, true)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "ltLongParams")
    public void lt(Long a, Long b, boolean expect) {
        boolean result = NumberUtils.lt(a, b);
        Assertions.assertEquals(result, expect);
    }

    public static List<Arguments> ltLongParams() {
        return Arrays.asList(
                Arguments.arguments(null, null, false),
                Arguments.arguments(null, 1L, false),
                Arguments.arguments(1L, null, false),
                Arguments.arguments(1L, 0L, false),
                Arguments.arguments(1L, 1L, false),
                Arguments.arguments(1L, -1L, false),
                Arguments.arguments(1L, 2L, true)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "leIntegerParams")
    public void le(Integer a, Integer b, boolean expect) {
        boolean result = NumberUtils.le(a, b);
        Assertions.assertEquals(result, expect);
    }

    public static List<Arguments> leIntegerParams() {
        return Arrays.asList(
                Arguments.arguments(null, null, false),
                Arguments.arguments(null, 1, false),
                Arguments.arguments(1, null, false),
                Arguments.arguments(1, 0, false),
                Arguments.arguments(1, 1, true),
                Arguments.arguments(1, -1, false),
                Arguments.arguments(1, 2, true)
        );
    }

    @ParameterizedTest
    @CsvSource({
            ",,false",
            ",1,false",
            "1,,false",
            "1,0,false",
            "1,1,true",
            "1,-1,false",
            "1,2,true"
    })
    public void le(Long a, Long b, boolean expect) {
        boolean result = NumberUtils.le(a, b);
        Assertions.assertEquals(result, expect);
    }

    @ParameterizedTest
    @CsvSource({
            ",,false",
            ",1,false",
            "1,,false",
            "1,0,false",
            "1,1,true",
            "1,-1,false",
            "1,2,false"
    })
    public void eq(Integer a, Integer b, boolean expect) {
        boolean result = NumberUtils.eq(a, b);
        Assertions.assertEquals(result, expect);
    }

    @ParameterizedTest
    @CsvSource({
            ",,false",
            ",1,false",
            "1,,false",
            "1,0,false",
            "1,1,true",
            "1,-1,false",
            "1,2,false"
    })
    public void eq(Long a, Long b, boolean expect) {
        boolean result = NumberUtils.eq(a, b);
        Assertions.assertEquals(result, expect);
    }

    @ParameterizedTest
    @CsvSource({
            ",,false",
            ",1,false",
            "1,,false",
            "1,0,true",
            "1,1,false",
            "1,-1,true",
            "1,2,false"
    })
    public void gt(Integer a, Integer b, boolean expect) {
        boolean result = NumberUtils.gt(a, b);
        Assertions.assertEquals(result, expect);
    }

    @ParameterizedTest
    @CsvSource({
            ",,false",
            ",1,false",
            "1,,false",
            "1,0,true",
            "1,1,false",
            "1,-1,true",
            "1,2,false"
    })
    public void gt(Long a, Long b, boolean expect) {
        boolean result = NumberUtils.gt(a, b);
        Assertions.assertEquals(result, expect);
    }

    @ParameterizedTest
    @CsvSource({
            ",,false",
            ",1,false",
            "1,,false",
            "1,0,true",
            "1,1,true",
            "1,-1,true",
            "1,2,false"
    })
    public void ge(Integer a, Integer b, boolean expect) {
        boolean result = NumberUtils.ge(a, b);
        Assertions.assertEquals(result, expect);
    }

    @ParameterizedTest
    @CsvSource({
            ",,false",
            ",1,false",
            "1,,false",
            "1,0,true",
            "1,1,true",
            "1,-1,true",
            "1,2,false"
    })
    public void ge(Long a, Long b, boolean expect) {
        boolean result = NumberUtils.ge(a, b);
        Assertions.assertEquals(result, expect);
    }
}
