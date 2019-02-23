package com.tazine.thread.create;

import java.util.concurrent.*;

/**
 * 线程创建测试
 *
 * @author frank
 * @date 2017/02/20
 */
public class CreateTest {

    public static void main(String[] args) throws Exception {
//        manuallyUsingThread();

        poolingUsingThread();
    }

    /**
     * 手动创建使用线程：三种方式
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
    private static void poolingUsingThread() throws Exception {
        // 1. 手动创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i < 15; i++) {
            Thread02 runnable = new Thread02();
            executor.execute(runnable);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    executor.getQueue().size() + "，已执行完成的任务数目：" + executor.getCompletedTaskCount());
        }
        // 关闭线程池
        executor.shutdown();

        // 2. 不提倡手动创建线程池，推荐 Executors类中的几个静态方法来创建线程
        // 从它们的具体实现来看，它们实际上也是调用了ThreadPoolExecutor，只不过参数都已配置好了
        // 创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
        ExecutorService executors1 = Executors.newCachedThreadPool();
        // 创建容量为1的缓冲池
        // Executor executors2 = Executors.newSingleThreadExecutor();
        // 创建固定容量大小的缓冲池
        // Executor executors3 = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            Thread02 runnable = new Thread02();
            executors1.submit(runnable);

            Thread03 callable = new Thread03();
            Future<String> future = executors1.submit(callable);
            System.out.println("Future: " + future.get());
        }
        executor.shutdown();
    }
}
