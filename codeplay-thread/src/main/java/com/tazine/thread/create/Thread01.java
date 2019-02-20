package com.tazine.thread.create;

/**
 * extends Thread 创建线程
 *
 * @author frank
 * @date 2017/2/20
 */
public class Thread01 extends Thread {

    @Override
    public void run() {
        System.err.println("通过extends Thread创建的线程正在执行");
    }
}
