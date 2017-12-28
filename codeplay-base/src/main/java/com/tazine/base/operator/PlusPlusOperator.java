package com.tazine.base.operator;

/**
 * Created by lina on 2017/12/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class PlusPlusOperator {

    public static void main(String[] args) {

        int i = 1;
        System.out.println(i++ + i++);
        System.out.println(i);
        // 3 3 执行顺序：首先执行第一个 i++，然后接着执行第二个i++，第一个i参与运算时是 1，第二个i参与运算时是2  1+2=3

        int j= 1;
        System.out.println(j++ + ++j);
        System.out.println(j);
        // 4 3

        int k=1;
        System.out.println(k++ + k++ + k++);
        System.out.println(k);
        // 6  4
    }
}
