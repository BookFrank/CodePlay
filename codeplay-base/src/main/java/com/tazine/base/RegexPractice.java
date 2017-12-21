package com.tazine.base;

/**
 * Created by lina on 2017/12/21.
 */
public class RegexPractice {

    public static void main(String[] args) {



        String s = "g21h32g435u2glugy421g21u3gl21";

        System.out.println(s.replaceAll("[0-9]", ""));
        System.out.println(s.replaceAll("[^0-9]", ""));

        String s1 = "2017-12-23 13:35:22";
        System.out.println(s1.replaceAll("\\D",""));

        // \d 匹配一个数字字符 等价于[0-9]
        // \D 匹配一个非数字字符 等价于[^0-9]


    }



}
