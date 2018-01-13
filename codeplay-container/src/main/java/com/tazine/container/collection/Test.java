package com.tazine.container.collection;

public class Test {

    public static void main(String[] args) {

        Object o  = new Object();
        System.out.println(Integer.toBinaryString(o.hashCode()));
        int h;
        int f = (h = o.hashCode()) ^ (h >>> 16);
        System.out.println(Integer.toBinaryString(f));
        System.out.println(Integer.toBinaryString(-1));

    }

}
