package com.tazine.thread.create;

/**
 * extends Thread 创建线程
 *
 * @author frank
 * @date 2017/2/20
 */
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        System.err.println(this.getName() + " 通过extends Thread创建的线程正在执行");
    }
}
