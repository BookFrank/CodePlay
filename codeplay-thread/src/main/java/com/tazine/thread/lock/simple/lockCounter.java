package com.tazine.thread.lock.simple;

/**
 * LockCounter：使用简单锁实现
 *
 * @author frank
 * @since 1.0.0
 */
public class lockCounter {

    public static void main(String[] args) {
        Counter counter = new Counter();
        for (int i = 0; i < 10; i++) {
            new Thread(counter).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(counter.getCount());
    }
}

class Counter implements Runnable {

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
//        Lock lock = new Lock();
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }
}
