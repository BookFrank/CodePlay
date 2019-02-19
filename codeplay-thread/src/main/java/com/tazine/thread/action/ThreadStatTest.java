package com.tazine.thread.action;

/**
 * 获取线程状态
 *
 * @author frank
 * @date 2018/07/26
 */
public class ThreadStatTest {

    public static void main(String[] args) throws InterruptedException {

        StateThread thread = new StateThread();

        System.out.println("当前线程状态为：" + thread.getState());

        thread.start();
        System.out.println("start(),线程状态为：" + thread.getState());

        // main线程休息，让state线程执行 sleep(500)
        Thread.sleep(100);
        System.out.println("当前线程状态为：" + thread.getState());

        // main线程继续休息，让state线程sleep(500)执行完，进入wait()无止境等待
        Thread.sleep(500);
        System.out.println("当前线程状态为：" + thread.getState());

        thread.notifyIt(); // 唤醒线程
        System.out.println("当前线程状态为：" + thread.getState());

        Thread.sleep(1000);
        System.out.println("当前线程状态为：" + thread.getState());
    }
}
