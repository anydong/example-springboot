package com.example.demo.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class NumberUtilsTests {
    @Test
    public void isPositiveTest() {
        // int
        Assert.isTrue(NumberUtils.isPositive(1));
        Assert.isTrue(!NumberUtils.isPositive(0));
        Assert.isTrue(!NumberUtils.isPositive(-1));
        // long
        Assert.isTrue(NumberUtils.isPositive(1L));
        Assert.isTrue(!NumberUtils.isPositive(0L));
        Assert.isTrue(!NumberUtils.isPositive(-1L));
    }

    @Test
    public void isPositiveOrZeroTest() {
        // int
        Assert.isTrue(NumberUtils.isPositiveOrZero(1));
        Assert.isTrue(NumberUtils.isPositiveOrZero(0));
        Assert.isTrue(!NumberUtils.isPositiveOrZero(-1));
        // long
        Assert.isTrue(NumberUtils.isPositiveOrZero(1L));
        Assert.isTrue(NumberUtils.isPositiveOrZero(0L));
        Assert.isTrue(!NumberUtils.isPositiveOrZero(-1L));
    }

    @Test
    public void isNegativeTest() {
        // int
        Assert.isTrue(NumberUtils.isNegative(-1));
        Assert.isTrue(!NumberUtils.isNegative(1));
        Assert.isTrue(!NumberUtils.isNegative(0));
        // long
        Assert.isTrue(NumberUtils.isNegative(-1L));
        Assert.isTrue(!NumberUtils.isNegative(1L));
        Assert.isTrue(!NumberUtils.isNegative(0L));
    }

    @Test
    public void isNegativeOrZeroTest() {
        // int
        Assert.isTrue(NumberUtils.isNegativeOrZero(0));
        Assert.isTrue(NumberUtils.isNegativeOrZero(-1));
        Assert.isTrue(!NumberUtils.isNegativeOrZero(1));
        // long
        Assert.isTrue(NumberUtils.isNegativeOrZero(0L));
        Assert.isTrue(NumberUtils.isNegativeOrZero(-1L));
        Assert.isTrue(!NumberUtils.isNegativeOrZero(1L));
    }
}
