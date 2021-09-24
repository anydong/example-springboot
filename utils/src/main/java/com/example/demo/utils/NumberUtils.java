package com.example.demo.utils;

public class NumberUtils {
    public static Boolean isPositive(Integer number) {
        return null != number && number > 0;
    }

    public static Boolean isPositive(Long number) {
        return null != number && number > 0L;
    }

    public static Boolean isPositiveOrZero(Integer number) {
        return null != number && number >= 0;
    }

    public static Boolean isPositiveOrZero(Long number) {
        return null != number && number >= 0L;
    }

    public static Boolean isNegative(Integer number) {
        return null != number && number < 0;
    }

    public static Boolean isNegative(Long number) {
        return null != number && number < 0L;
    }

    public static Boolean isNegativeOrZero(Integer number) {
        return null != number && number <= 0;
    }

    public static Boolean isNegativeOrZero(Long number) {
        return null != number && number <= 0L;
    }
}
