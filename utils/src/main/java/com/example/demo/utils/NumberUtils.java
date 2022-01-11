package com.example.demo.utils;

/**
 * Number 类型值校验
 * 只做数值判断，不做数据类型判断
 *
 * @author where.liu
 */
public class NumberUtils {
    /**
     * 校验 Integer 是否为 > 0 的正整数
     *
     * @param number 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isPositive(Number number) {
        return null != number && Double.compare(number.doubleValue(), 0.0) > 0;
    }

    /**
     * 校验 Integer 是否为 >= 0 的正整数
     *
     * @param number 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isPositiveOrZero(Number number) {
        return null != number && Double.compare(number.doubleValue(), 0.0) >= 0;
    }

    /**
     * 校验 Integer 是否为 < 0 的整数
     *
     * @param number 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isNegative(Number number) {
        return null != number && Double.compare(number.doubleValue(), 0.0) < 0;
    }

    /**
     * 校验 Integer 是否为 <= 0 的整数
     *
     * @param number 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isNegativeOrZero(Number number) {
        return null != number && Double.compare(number.doubleValue(), 0.0) <= 0;
    }

    /**
     * a < b
     *
     * @return true or false
     */
    public static boolean lt(Number a, Number b) {
        return a != null && b != null && Double.compare(a.doubleValue(), b.doubleValue()) < 0;
    }

    /**
     * a <= b
     *
     * @return true or false
     */
    public static boolean le(Number a, Number b) {
        return a != null && b != null && Double.compare(a.doubleValue(), b.doubleValue()) <= 0;
    }

    /**
     * a == b
     *
     * @return true or false
     */
    public static boolean eq(Number a, Number b) {
        return a != null && b != null && Double.compare(a.doubleValue(), b.doubleValue()) == 0;
    }

    /**
     * a > b
     *
     * @return true or false
     */
    public static boolean gt(Number a, Number b) {
        return a != null && b != null && Double.compare(a.doubleValue(), b.doubleValue()) > 0;
    }

    /**
     * a >= b
     *
     * @return true or false
     */
    public static boolean ge(Number a, Number b) {
        return a != null && b != null && Double.compare(a.doubleValue(), b.doubleValue()) >= 0;
    }
}

