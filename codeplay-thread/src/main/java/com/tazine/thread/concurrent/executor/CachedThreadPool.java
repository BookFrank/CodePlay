package com.tazine.thread.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newCachedThreadPool()
 *
 * @author frank
 * @since 1.0.0
 */
public class CachedThreadPool {

    /**
     * shundown() 方法可以防止新任务被提交给这个 Executor，当前线程（main（）线程）将继续运行在 shuntdown()
     * 被调用之前提交的所有任务
     */

    public static void main(String[] args) {

        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            pool.submit(new PrinterThread());
        }
        pool.shutdown();
    }
}
