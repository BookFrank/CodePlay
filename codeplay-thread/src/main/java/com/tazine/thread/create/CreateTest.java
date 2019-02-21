package com.tazine.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * CreateTest
 *
 * @author frank
 * @date 2017/02/20
 */
public class CreateTest {

    public static void main(String[] args) throws Exception {
        manuallyUsingThread();

        poolingUsingThread();
    }

    /**
     * 三种方式手动创建线程使用
     */
    private static void manuallyUsingThread() throws ExecutionException, InterruptedException {
        // 1. 方式一
        Thread thread01 = new Thread01();
        thread01.start();

        // 2. 方式二
        Thread02 runnable = new Thread02();
        Thread thread02 = new Thread(runnable);
        thread02.start();

        // 3. 方式三 Callable + FutureTask
        Callable<String> callable = new Thread03();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        // Future<String> future = new FutureTask<>(callable);
        // System.out.println(future.get());

        new Thread(futureTask).start();
        System.err.println("开始执行 main 线程");

        // get() 是阻塞的，直到有结果才返回
        System.err.println(futureTask.get());
    }

    /**
     * 线程池方式使用线程
     */
    private static void poolingUsingThread() {

    }
}
