package com.tazine.io.netty.paio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 伪异步线程池
 *
 * @author frank
 * @since 1.0.0
 */
public class PioHandlerPool {

    private ThreadPoolExecutor pool;
    //private ExecutorService pool;

    public PioHandlerPool(int maxPoolSize, int queueSize) {
        pool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 120L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
        //pool = Executors.newSingleThreadExecutor();
        System.out.println("线程池中线程数目：" + pool.getPoolSize() + "，队列中等待执行的任务数目：" +
                pool.getQueue().size() + "，已执行完毕的任务数目：" + pool.getCompletedTaskCount());
    }

    public void submit(Runnable task) {
        pool.submit(task);
        System.out.println("线程池中线程数目：" + pool.getPoolSize() + "，队列中等待执行的任务数目：" +
                pool.getQueue().size() + "，已执行完毕的任务数目：" + pool.getCompletedTaskCount());
    }
}
