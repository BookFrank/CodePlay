package com.tazine.thread.action;

/**
 * 线程状态
 *
 * @author frank
 * @since 1.0.0
 */
public class ThreadState extends Thread {

    public synchronized void waitForASecond() throws InterruptedException {
        wait(500);
    }

    public synchronized void waitForever() throws InterruptedException {
        wait();
    }

    public synchronized void notifyIt() {
        notify();
    }

    @Override
    public void run() {
        try {
            waitForASecond();
            waitForever();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
