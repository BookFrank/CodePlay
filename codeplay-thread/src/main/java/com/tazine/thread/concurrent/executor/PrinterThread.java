package com.tazine.thread.concurrent.executor;

/**
 * PrinterThread
 *
 * @author frank
 * @since 1.0.0
 */
public class PrinterThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(currentThread().getName() + "打印中......");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(currentThread().getName() + " 执行完毕");
    }
}
