package com.tazine.codeplay.version.java8.stream;

import java.awt.*;
import java.util.Arrays;

/**
 * StreamTest
 *
 * @author frank
 * @date 2019/04/28
 */
public class StreamTest {

    public static void main(String[] args) {

        String[] strings = new String[3];
        strings[0] = "frank";
        strings[1] = "peter";
        strings[2] = "kobe";

        // for 循环中的return 会终止程序执行
        for (int i=0; i<strings.length; i++){
            System.out.println(strings[i]);
            if (strings[i].equalsIgnoreCase("frank")){
                return;
            }
        }

        // lambda 中的 return 指的是退出本次循环，不会终止程序执行
        //Arrays.stream(strings).forEach(name -> {
        //    if (name.equalsIgnoreCase("frank")){
        //        return;
        //    }
        //    System.out.println(name);
        //});
        System.out.println("Hello World");
    }
}
