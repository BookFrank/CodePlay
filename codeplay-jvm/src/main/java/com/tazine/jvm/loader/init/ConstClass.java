package com.tazine.jvm.loader.init;

/**
 * Created by lina on 2017/12/28.
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
