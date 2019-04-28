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

        //for (int i=0; i<strings.length; i++){
        //    if (strings[i].equalsIgnoreCase("frank")){
        //        return;
        //    }
        //}

        Arrays.stream(strings).forEach(name -> {
            if (name.equalsIgnoreCase("frank")){
                return;
            }
            System.out.println(name);
        });
        System.out.println("Hello World");
    }
}
