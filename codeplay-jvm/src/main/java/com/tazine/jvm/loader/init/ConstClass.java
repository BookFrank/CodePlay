package com.tazine.jvm.loader.init;

/**
 * ConstClass
 *
 * @author frank
 * @since 1.0.0
 */
public class ConstClass {
    static {
        System.out.println("ConstClass Init...");
    }
    public static final String HW = "Hello World";
}
