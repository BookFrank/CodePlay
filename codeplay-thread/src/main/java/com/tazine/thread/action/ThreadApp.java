package com.tazine.thread.action;

/**
 * 获取线程状态
 *
 * @author Frank
 * @since 1.0.0
 */
public class ThreadApp {


    public static void main(String[] args) throws InterruptedException {

        ThreadState thread = new ThreadState();

        System.out.println("当前线程状态为：" + thread.getState());

        thread.start();
        System.out.println("当前线程状态为：" + thread.getState());

        Thread.sleep(100);  // main线程休息，让state线程执行 sleep(500)
        System.out.println("当前线程状态为：" + thread.getState());

        Thread.sleep(500); // main线程继续休息，让state线程sleep(500)执行完，进入wait()无止境等待
        System.out.println("当前线程状态为：" + thread.getState());

        thread.notifyIt(); // 唤醒线程
        System.out.println("当前线程状态为：" + thread.getState());

        Thread.sleep(1000);
        System.out.println("当前线程状态为：" + thread.getState());
    }


}
