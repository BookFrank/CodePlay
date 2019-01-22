package com.tazine.jvm.exception;

/**
 * GCDemo
 *
 * @author frank
 * @date 2019/01/22
 */
public class GCDemo {

    private static final int _1MB = 1024 * 1024;

    /**
     * VM Args：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     *
     * @param args args
     */
    public static void main(String[] args) {

        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];

        // 出现一次 Minor GC
        allocation4 = new byte[2 * _1MB];
    }
}
