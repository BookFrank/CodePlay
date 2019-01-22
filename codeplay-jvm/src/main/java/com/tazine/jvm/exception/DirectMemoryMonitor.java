package com.tazine.jvm.exception;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;

/**
 * DirectMemoryMonitor
 *
 * @author frank
 * @date 2019/1/22
 */
public class DirectMemoryMonitor {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {

        try {
            Class c = Class.forName("java.nio.Bits");
            Field field1 = c.getDeclaredField("maxMemory");
            field1.setAccessible(true);
            Field field2 = c.getDeclaredField("reservedMemory");
            field2.setAccessible(true);
            synchronized (c) {
                Long max = (Long) field1.get(null);
                AtomicLong reserve = (AtomicLong) field2.get(null);
                System.out.println(max/_1M + " " + reserve.get()/_1M);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
