package com.tazine.thread.action;

/**
 * Join方法测试
 * <p> join()定义是等待线程的终止，join 将挂起调用线程的执行，直到被调用线程完成它的执行 </>
 *
 * @author frank
 * @date 2019/05/24
 */
public class JoinFuncDemo {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> System.out.println("Thread 01 Running"));
        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
                // 因为是在 thread02 线程中调用 thread01.join，将挂起 thread02 线程的执行，直到 thread1 执行完毕
                Thread.sleep(2000);
                System.out.println("Thread 02 Running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                thread2.join();
                Thread.sleep(2000);
                System.out.println("Thread 03 Running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
