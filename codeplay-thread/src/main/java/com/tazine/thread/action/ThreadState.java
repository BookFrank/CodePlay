package com.tazine.thread.action;

/**
 * 线程状态
 *
 * @author Frank
 * @since 1.0.0
 */
public class ThreadState extends Thread{


    public synchronized void waitForASecond() throws InterruptedException {
        wait(500);
    }

    public synchronized void waitForver() throws InterruptedException {
        wait();
    }

    public synchronized void notifyIt(){
        notify();
    }

    @Override
    public void run() {
        try {
            waitForASecond();
            waitForver();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
