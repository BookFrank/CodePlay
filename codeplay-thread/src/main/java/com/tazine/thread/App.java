package com.tazine.thread;

/**
 * Hello world!
 *
 * @author frank
 * @date 2018/02/26
 */
public class App {

    private boolean flag = false;

    private int i = 0;

    public synchronized void minus() throws InterruptedException {
        if (flag) {
            i--;
            flag = true;
            notify();
        } else {
            wait();
        }
    }

    public synchronized void add() throws InterruptedException {
        if (flag) {
            i++;
            flag = true;
            notify();
        } else {
            wait();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        App app = new App();

        MyThread thread = new MyThread(app);
        Thread2 thread2 = new Thread2(app);

        thread.start();
        synchronized (app) {
            thread.wait();
        }
//        app.wait();

        System.out.println("Hello World!");
    }
}
