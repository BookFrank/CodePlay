package com.tazine.thread.concurrent.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by lina on 2017/12/29.
 *
 * @author frank
 * @since 1.0.0
 */
public class BasicPool {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 15; i++) {
            pool.execute(new Thinker());
            System.out.println("线程池中线程数目：" + pool.getPoolSize() + "，队列中等待执行的任务数目：" +
                    pool.getQueue().size() + "，已执行玩别的任务数目：" + pool.getCompletedTaskCount());
        }
        pool.shutdown();
    }
}

class Thinker implements Runnable {

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
