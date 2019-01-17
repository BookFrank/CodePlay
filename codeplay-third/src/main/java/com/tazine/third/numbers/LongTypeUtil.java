package com.tazine.third.numbers;

/**
 * LongTypeUtil
 *
 * @author frank
 * @date 2019/01/16
 */
public class LongTypeUtil {

    public static void main(String[] args) {

        Double d1 = 1.394586150001488;

        // 2.0 ceil 向上取整
        double ceilD1 = Math.ceil(d1);
        System.out.println(ceilD1);

        // 1.0 round 四舍五入
        double roundD1 = Math.round(d1);
        System.out.println(roundD1);
    }

}
