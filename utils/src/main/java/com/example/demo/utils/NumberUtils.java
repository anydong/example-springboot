package com.example.demo.utils;


/**
 * Number 类型值校验
 *
 * @author where.liu
 */
public class NumberUtils {
    /**
     * 校验 Integer 是否为 > 0 的正整数
     *
     * @param value 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isPositive(Integer value) {
        return value != null && value > 0;
    }

    /**
     * 校验 Long 是否为 > 0 的正整数
     *
     * @param value 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isPositive(Long value) {
        return value != null && value > 0L;
    }

    /**
     * 校验 Integer 是否为 >= 0 的正整数
     *
     * @param value 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isPositiveOrZero(Integer value) {
        return value != null && value >= 0;
    }

    /**
     * 校验 Long 是否为 >= 0 的正整数
     *
     * @param value 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isPositiveOrZero(Long value) {
        return value != null && value >= 0L;
    }

    /**
     * 校验 Integer 是否为 < 0 的整数
     *
     * @param value 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isNegative(Integer value) {
        return value != null && value < 0;
    }

    /**
     * 校验 Long 是否为 < 0 的整数
     *
     * @param value 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isNegative(Long value) {
        return value != null && value < 0L;
    }

    /**
     * 校验 Integer 是否为 <= 0 的整数
     *
     * @param value 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isNegativeOrZero(Integer value) {
        return value != null && value <= 0;
    }

    /**
     * 校验 Long 是否为 <= 0 的整数
     *
     * @param value 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isNegativeOrZero(Long value) {
        return value != null && value <= 0L;
    }

    /**
     * a < b
     *
     * @return true or false
     */
    public static boolean lt(Integer a, Integer b) {
        return a != null && b != null && a.compareTo(b) < 0;
    }

    /**
     * a < b
     *
     * @return true or false
     */
    public static boolean lt(Long a, Long b) {
        return a != null && b != null && a.compareTo(b) < 0;
    }

    /**
     * a <= b
     *
     * @return true or false
     */
    public static boolean le(Integer a, Integer b) {
        return a != null && b != null && a.compareTo(b) <= 0;
    }

    /**
     * a <= b
     *
     * @return true or false
     */
    public static boolean le(Long a, Long b) {
        return a != null && b != null && a.compareTo(b) <= 0;
    }

    /**
     * a == b
     *
     * @return true or false
     */
    public static boolean eq(Integer a, Integer b) {
        return a != null && b != null && a.compareTo(b) == 0;
    }

    /**
     * a == b
     *
     * @return true or false
     */
    public static boolean eq(Long a, Long b) {
        return a != null && b != null && a.compareTo(b) == 0;
    }

    /**
     * a > b
     *
     * @return true or false
     */
    public static boolean gt(Integer a, Integer b) {
        return a != null && b != null && a.compareTo(b) > 0;
    }

    /**
     * a > b
     *
     * @return true or false
     */
    public static boolean gt(Long a, Long b) {
        return a != null && b != null && a.compareTo(b) > 0;
    }

    /**
     * a >= b
     *
     * @return true or false
     */
    public static boolean ge(Integer a, Integer b) {
        return a != null && b != null && a.compareTo(b) >= 0;
    }

    /**
     * a >= b
     *
     * @return true or false
     */
    public static boolean ge(Long a, Long b) {
        return a != null && b != null && a.compareTo(b) >= 0;
    }
}

