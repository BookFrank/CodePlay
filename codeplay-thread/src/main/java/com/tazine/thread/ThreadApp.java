package com.tazine.thread;

/**
 * @author Frank
 */
public class ThreadApp {


    public static void main(String[] args) {

        ThreadState thread = new ThreadState();

        System.out.println("当前线程状态为：" + thread.getState());

        thread.start();
        System.out.println("当前线程状态为：" + thread.getState());

        

    }


}
