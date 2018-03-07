package com.tazine.container.collection;


import java.util.HashMap;

/**
 * Collection Test
 *
 * @author frank
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(Integer.toBinaryString(o.hashCode()));
        int h;
        int f = (h = o.hashCode()) ^ (h >>> 16);
        System.out.println(Integer.toBinaryString(f));
        System.out.println(Integer.toBinaryString(-1));

    }
}
