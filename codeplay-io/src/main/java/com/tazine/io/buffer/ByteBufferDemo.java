package com.tazine.io.buffer;

import java.nio.ByteBuffer;

/**
 * ByteBufferDemo
 *
 * @author frank
 * @date 2017/11/19
 */
public class ByteBufferDemo {

    public static void main(String[] args) {

        System.out.println("------- Test Allocate -------");
        System.out.println("Before allocate :" + Runtime.getRuntime().freeMemory() / 1024 /1024 );

        /**
         * 1k = 1024byte 这个就相当于10M，使用JVM内存
         */
        ByteBuffer buffer = ByteBuffer.allocate(10240000);

        System.out.println("buffer :" + buffer);
        System.out.println("After allocate :" + Runtime.getRuntime().freeMemory() / 1024 /1024 );


        /**
         * 直接使用系统内存，对JVM无影响
         */
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(102400000);
        System.out.println("directBuffer :" + directBuffer);
        System.out.println("After direct allocate :" + Runtime.getRuntime().freeMemory() / 1024 /1024 );


        System.out.println("------- Test wrap --------");
        byte[] bytes = new byte[32];
        buffer = ByteBuffer.wrap(bytes);
        System.out.println("buffer :" + buffer);

        System.out.println();
    }
}
