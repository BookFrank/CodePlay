package com.tazine.thread.action;

/**
 * 线程的插队
 *
 * @author frank
 * @date 2018/07/26
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new EmergencyCar());
        thread.start();

        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("正常情况：" + i + " 号车出发");

            thread.join();

            // 这样做没反应
            // Thread.currentThread().join();
        }
    }
}

class EmergencyCar implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" 紧急情况：" + i + " 号车出发");
        }
    }
}