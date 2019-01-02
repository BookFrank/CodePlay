package com.tazine.thread.concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Callable & Future Demo
 *
 * @author frank
 * @date 2018/1/8
 */
public class CallableAndFuture2 {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newSingleThreadExecutor();

        Future<Integer> future = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(10);
            }
        });

        try {
            /**
             * 在得到返回值之前可以做一些别的任务
             */
            Thread.sleep(1000);
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
