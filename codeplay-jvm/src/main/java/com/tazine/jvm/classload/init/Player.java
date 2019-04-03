package com.tazine.jvm.classload.init;

/**
 * Father
 *
 * @author frank
 * @date 2017/12/12
 */
public class Player {
    static {
        System.out.println("Player Init...");
    }

    static String gender = "MALE";
}
