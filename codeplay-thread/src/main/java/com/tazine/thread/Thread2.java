package com.tazine.thread;

/**
 * Thread2
 *
 * @author frank
 * @date 2018/07/26
 */
public class Thread2 extends Thread {

    private App app;

    public Thread2(App app) {
        this.app = app;
    }

    @Override
    public void run() {
        System.out.println("线程答应");
        try {
            app.minus();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
