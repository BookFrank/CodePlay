package com.tazine.jvm.loader.init;

/**
 * Child
 *
 * @author frank
 * @date 2017/12/12
 */
public class Kobe extends Player {
    static {
        System.out.println("Kobe Init...");
    }

    public static void main(String[] args) {
        System.out.println(Kobe.gender);
    }
}
