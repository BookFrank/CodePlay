package com.tazine.thread.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程中介：按顺序执行加进来的任务，每次只有一个线程工作
 *
 * @author frank
 * @since 1.0.0
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            exec.execute(new PrinterThread());
        }
        exec.shutdown();
    }
}
