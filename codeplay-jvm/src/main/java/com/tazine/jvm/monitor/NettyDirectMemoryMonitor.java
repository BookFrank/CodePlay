package com.tazine.jvm.monitor;

import io.netty.util.internal.PlatformDependent;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 使用到Netty的堆外内存监控
 *
 * @author frank
 * @date 2018/01/28
 */
public class NettyDirectMemoryMonitor {

    private static final int _1k = 1024;

    private AtomicLong directMemory;

    public void NettyDirectMemoryMonitor() throws Exception {
        Class c = Class.forName("io.netty.util.internal.PlatformDependent");
        Field field = c.getDeclaredField("DIRECT_MEMORY_COUNTER");
        field.setAccessible(true);

        try {
            directMemory = (AtomicLong)field.get(PlatformDependent.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void report() {
        System.out.println("[DIRECT_MEMORY] 当前堆外内存 " + directMemory.get() / _1k + " K");
    }
}
