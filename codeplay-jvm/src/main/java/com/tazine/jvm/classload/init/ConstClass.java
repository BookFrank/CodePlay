package com.tazine.jvm.classload.init;

/**
 * ConstClass
 *
 * @author frank
 * @date 2017/12/12
 */
public class ConstClass {
    static {
        System.out.println("ConstClass Init...");
    }
    public static final String HW = "Hello World";
}
