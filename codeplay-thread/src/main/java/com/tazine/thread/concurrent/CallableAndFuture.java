package com.tazine.thread.concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Callable接口类似Runnable，但是Runnable不会返回结果，并且无法抛出返回结果的异常，
 * 而Callable被线程执行后，可以有返回值，这个返回值可以被Future拿到，Future可以拿到异步执行任务的返回值。
 *
 * @author frank
 * @since 1.0.0
 */
public class CallableAndFuture {

    public static void main(String[] args) {

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };

        /**
         * FutureTask 实现了两个接口Runnable和Future，既可以作为Runnable被线程执行，
         * 又能作为Future得到Callable的返回值
         */
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();

        try {
            /**
             * 在拿到返回值之前可以去做一些别的任务
             */
            Thread.sleep(2000);
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
