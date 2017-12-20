package com.tazine.base.operator;

/**
 * 三目运算符
 *
 * @author frank
 * @since 1.0.0
 */
public class TripOperator {

    public static void main(String[] args) {

        boolean b = true ? false : true == true ? false : true; // 三目运算符具有右结合性
        System.out.println(b);

        int i = 5;
        System.out.println("value is " + ( i < 5 ? 10.9 : 9 )); // Java会根据运算符的精度类型进行自动转换

        char x = 'x';
        int j = 10;
        System.out.println(false ? i : x);
        System.out.println(false ? 10 : x);
        // 两个表达式，有一个是常量表达式时，另一个是T，而常量表达式可以被T表示时，输出结果是T类型。

        System.out.println(32 >> 32);
        System.out.println(32 >> 33);
        System.out.println(1 << 3);



    }

}
