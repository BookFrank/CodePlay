package com.tazine.thread;

import com.tazine.thread.App;

/**
 * Created by lina on 2017/8/23.
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
