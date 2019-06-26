package com.tazine.base;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * NumberUtils
 *
 * @author frank
 * @date 2019/06/26
 */
public class NumberUtils {

    public static void main(String[] args) {

        double d1 = 3.1415926;
        //double d2 = 300.7;
        double d2 = 300.7595926;


        // 1. DecimalFormat
        // 位数不足，会补0
        DecimalFormat df = new DecimalFormat("#.00");
        // 会四舍五入
        System.out.println(df.format(d1));
        System.out.println(df.format(d2));

        // 2. BigDecimal
        // 位数不足，不会补0
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        double f2 = b2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f2);

        //
        System.out.println(getDoubleWithLen(d2, 3));
    }

    public static double getDoubleWithLen(double d, int len){
        StringBuilder sb = new StringBuilder();
        sb.append("#0.");
        while (len-- >0){
            sb.append("0");
        }
        DecimalFormat df = new DecimalFormat();
        df.applyPattern(sb.toString());
        return Double.parseDouble(df.format(d));
    }
}
