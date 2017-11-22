package com.tazine.thread;
import java.util.concurrent.*;
/**
 * Volatile关键词：能够实现可见性，但是无法实现原子性
 * @author Frank
 */
public class VolatileDemo {

    private volatile int result = 0;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

    }


}
