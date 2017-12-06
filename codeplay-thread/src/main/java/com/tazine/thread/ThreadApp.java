package com.tazine.thread;

/**
 * @author Frank
 */
public class ThreadApp {


    public static void main(String[] args) throws InterruptedException {

        ThreadState thread = new ThreadState();

        System.out.println("当前线程状态为：" + thread.getState());

        thread.start();
        System.out.println("当前线程状态为：" + thread.getState());

        Thread.sleep(100);
        System.out.println("当前线程状态为：" + thread.getState());

        Thread.sleep(1000);
        System.out.println("当前线程状态为：" + thread.getState());

        thread.notifyIt();
        System.out.println("当前线程状态为：" + thread.getState());

        Thread.sleep(1000);
        System.out.println("当前线程状态为：" + thread.getState());
    }


}
