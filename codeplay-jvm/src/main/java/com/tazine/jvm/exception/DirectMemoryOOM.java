package com.tazine.jvm.exception;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

/**
 * 直接内存溢出
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 *
 * @author frank
 * @date 2019/01/22
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException, InterruptedException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true){
            TimeUnit.SECONDS.sleep(1);
            unsafe.allocateMemory(_1MB);
        }
    }
}
