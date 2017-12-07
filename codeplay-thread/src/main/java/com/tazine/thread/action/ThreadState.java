package com.tazine.thread.action;

/**
 * Created by lina on 2017/12/6.
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
