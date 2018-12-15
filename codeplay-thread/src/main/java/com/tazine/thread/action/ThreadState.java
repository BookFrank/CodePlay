package com.tazine.thread.action;

/**
 * 线程状态
 *
 * @author frank
 * @date 2018/07/26
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
