package com.tazine.jvm.loader.init;

/**
 * Child
 *
 * @author frank
 * @since 1.0.0
 */
public class Kobe extends Player {
    static {
        System.out.println("Kobe Init...");
    }

    public static void main(String[] args) {
        System.out.println(Kobe.gender);
    }
}
