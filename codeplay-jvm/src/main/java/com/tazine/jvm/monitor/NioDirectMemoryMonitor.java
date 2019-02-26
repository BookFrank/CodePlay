package com.tazine.jvm.monitor;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 使用到原生NIO的堆外内存监控
 *
 * @author frank
 * @date 2018/01/25
 */
public class NioDirectMemoryMonitor {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                report();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void report() {
        try {
            Class c = Class.forName("java.nio.Bits");
            // 总内存大小
            Field field1 = c.getDeclaredField("maxMemory");
            field1.setAccessible(true);
            // 剩余内存大小
            Field field2 = c.getDeclaredField("reservedMemory");
            field2.setAccessible(true);
            synchronized (c) {
                Long max = (Long)field1.get(null);
                AtomicLong reserve = (AtomicLong)field2.get(null);
                System.out.println(max / _1M + " " + reserve.get() / _1M);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
