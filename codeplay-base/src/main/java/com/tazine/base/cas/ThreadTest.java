package com.tazine.base.cas;

/**
 * 线程测试
 *
 * @author frank
 * @date 2019/01/28
 */
public class ThreadTest {
    
    public static void main(String[] args) {
        // 在main线程中创建线程，即便 main 线程最后退出，创建的线程依然会执行
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }
        }).start();

        System.out.println("main 线程执行完成");
    }
}
