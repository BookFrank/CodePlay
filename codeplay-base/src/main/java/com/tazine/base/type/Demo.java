package com.tazine.base.type;

/**
 * Demo
 *
 * @author frank
 * @date 2017/12/20
 */
public class Demo {

    public static void main(String[] args) {

        short s = 1;
        // s = s + 1; 会报编译错误
        s+=1;
        System.out.println(s);


        boolean flag = true;
        String str = String.valueOf(flag);
        System.out.println(str);
    }
}
