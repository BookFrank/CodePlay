package com.tazine.base.operator;

/**
 * 算数运算符
 *
 * @author frank
 * @since 1.0.0
 */
public class MathOperator {

    public static void main(String[] args) {

        int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
        }
        System.out.println(j);

        /*
            j=j++; 由于java使用了中间缓存变量的机制，因此 j=j++ 可以重写为：
            temp=j;  j=j+1; j=temp;
         */

    }

}
