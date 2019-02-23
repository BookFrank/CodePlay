package com.tazine.thread.create;

/**
 * 线程状态
 *
 * @author frank
 * @date 2018/07/26
 */
public class ThreadStateDemo extends Thread {

    private synchronized void waitForASecond() throws InterruptedException {
        wait(500);
    }

    private synchronized void waitForever() throws InterruptedException {
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
