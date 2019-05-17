package com.tazine.thread.lock;

import com.tazine.thread.lock.reentrant.ReentrantPrinter;
import com.tazine.thread.lock.spinlock.SpinPrinter;
import com.tazine.thread.lock.synchron.SynchronicPrinter;

/**
 * Test
 *
 * @author frank
 * @date 2019/05/16
 */
public class Test {

    private static String s1 = "Hello";
    private static String s2 = "World";

    public static void main(String[] args) {
        // 基于 synchronized 关键字的锁
        //synchronicLock();

        // 自旋锁
        //spinLock();

        // 可重入算
        reentrantLock();
    }

    private static void spinLock(){
        SpinPrinter spinPrinter = new SpinPrinter();
        new Thread(() -> spinPrinter.print(s1)).start();
        new Thread(() -> spinPrinter.print(s2)).start();
    }

    private static void synchronicLock(){
        SynchronicPrinter printer1 = new SynchronicPrinter();
        new Thread(() -> printer1.print(s1)).start();
        new Thread(() -> printer1.print(s2)).start();
    }

    private static void reentrantLock(){
        ReentrantPrinter printer = new ReentrantPrinter();
        new Thread(() -> printer.print(s1)).start();
        new Thread(() -> printer.print(s2)).start();
    }
}
