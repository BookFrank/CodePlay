package com.tazine.base;

/**
 * 强制类型转换之Numbers
 *
 * @author Frank
 * @since 1.0.0
 */
public class CastingNumbers {

    public static void main(String[] args) {
        double high = 0.8, low = 0.4;
        float fhigh = 0.8f, flow = 0.4f;

        System.out.println("(int) high = " + (int) high);
        System.out.println("(int) low = " + (int) low);
        System.out.println("(int) fhigh = " + (int) fhigh);
        System.out.println("(int) flow = " + (int) flow);
        System.out.println();
        System.out.println("Math.round(high) = " + Math.round(high));
        System.out.println("Math.round(low) = " + Math.round(low));
        System.out.println("Math.round(fhigh) = " + Math.round(fhigh));
        System.out.println("Math.round(flow) = " + Math.round(flow));

        /*
            在将float或double转型为整型时，总是对该数字执行暴力截尾；
            如果想要得到舍入的结构，就需要使用Math.round()；
            Math是java.lang的一部分，因此不需要额外导入。
         */
    }
}
