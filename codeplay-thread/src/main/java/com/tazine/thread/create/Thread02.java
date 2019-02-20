package com.tazine.thread.create;

/**
 * 通过实现Runnable接口创建线程
 *
 * @author frank
 * @date 2019/2/20
 */
public class Thread02 implements Runnable {
    @Override
    public void run() {
        System.err.println("通过实现Runnable接口创建的线程正在执行");
    }
}
