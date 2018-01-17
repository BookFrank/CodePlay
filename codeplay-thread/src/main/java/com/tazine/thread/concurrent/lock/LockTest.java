package com.tazine.thread.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LockTest
 *
 * @author frank
 * @since 1.0.0
 */
public class LockTest {
    public static void main(String[] args) {
        String a = "kobe";
        String b = "james";

        Outputer outputer = new Outputer();

        new Thread() {
            @Override
            public void run() {
                outputer.print(a);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                outputer.print(b);
            }
        }.start();

    }
}

class Outputer {

    private Lock lock = new ReentrantLock();

    public void print(String words) {
        lock.lock();
        try {
            for (int i = 0; i < words.length(); i++) {
                System.out.print(words.charAt(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(" ");
        } finally {
            /**
             * 为了保证锁最终被释放(即使发生异常情况)，要把互斥区放在try内，释放锁放在finally内
             */
            lock.unlock();
        }
    }
}
