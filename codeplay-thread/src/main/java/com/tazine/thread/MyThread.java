package com.tazine.thread;

/**
 * 线程
 *
 * @author frank
 * @date 2018/02/26
 */
public class MyThread extends Thread {

    private App app;

    public MyThread(App app) {
        this.app = app;
    }

    @Override
    public void run() {
        System.out.println("线程答应");
        try {
            app.add();
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
