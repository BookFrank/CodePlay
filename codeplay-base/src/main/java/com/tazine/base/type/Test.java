package com.tazine.base.type;

/**
 * Created by lina on 2017/12/20.
 */
public class Test {

    public static void main(String[] args) {

        // 0 开头的数字为8进制
        int i = 012;
        //int j = 078; 编译错误
        int k = (int) 056L;
        System.out.println(i);
        System.out.println(k);

    }

}
