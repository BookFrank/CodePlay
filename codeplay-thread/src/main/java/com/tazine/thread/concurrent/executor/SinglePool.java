package com.tazine.thread.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by lina on 2017/12/29.
 *
 * @author frank
 * @since 1.0.0
 */
public class SinglePool {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 15; i++) {
            executor.execute(new Counter());
        }
        executor.shutdown();
    }
}


class MyThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}


class Counter implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 正在执行");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 执行完毕");
    }
}
