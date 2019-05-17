package com.tazine.thread.lock.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁打印机
 *
 * @author frank
 * @date 2019/05/16
 */
public class ReentrantPrinter {

    private Lock lock = new ReentrantLock();

    public void print(String words){
        try {
            lock.lock();
            for (char c : words.toCharArray()) {
                System.out.print(c);
                Thread.sleep(500);
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
