package com.tazine.base;

/**
 * Created on 2017/12/3.
 */
public class Cal {

    // 自增、自减运算符
    // 放在变量之前的自增、自减运算符，会使该变量的值先加1，然后再使该变量参与表达式的运算


    public static void main(String[] args) {

        int a = 4;
        int b = ++a;
        int c = a++;

        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }

}
