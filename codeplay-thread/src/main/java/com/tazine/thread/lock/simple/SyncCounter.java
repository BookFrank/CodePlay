package com.tazine.thread.lock.simple;

/**
 * 使用 synchronized 实现的线程安全 counter
 *
 * @author frank
 * @since 1.0.0
 */
public class SyncCounter {
    public static void main(String[] args) {

        SynCounter counter = new SynCounter();
        for (int i = 0; i < 10; i++) {
            new Thread(counter).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(counter.getCount());
    }
}

class SynCounter implements Runnable {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }
    }
}
