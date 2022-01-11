package com.example.demo.utils;

/**
 * Number 类型值校验, 只做数值判断，不做数据类型判断
 * 支持入参数据类型：byte, short, int, long, float, double
 *
 * @author where.liu
 */
public class NumberUtils {
    /**
     * 校验入参是否为 > 0 的正数
     *
     * @param a 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isPositive(Number a) {
        return null != a && Double.compare(a.doubleValue(), 0.0) > 0;
    }

    /**
     * 校验入参是否为 >= 0 的正数
     *
     * @param a 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isPositiveOrZero(Number a) {
        return null != a && Double.compare(a.doubleValue(), 0.0) >= 0;
    }

    /**
     * 校验入参是否为 < 0 的负数
     *
     * @param a 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isNegative(Number a) {
        return null != a && Double.compare(a.doubleValue(), 0.0) < 0;
    }

    /**
     * 校验入参是否为 <= 0 的负数
     *
     * @param a 待校验的值，可以为 null
     * @return true or false
     */
    public static boolean isNegativeOrZero(Number a) {
        return null != a && Double.compare(a.doubleValue(), 0.0) <= 0;
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

