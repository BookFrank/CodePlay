package com.tazine.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程中介：按顺序执行加进来的任务，每次只有一个线程工作
 *
 * @author frank
 * @date 2017/12/26
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
