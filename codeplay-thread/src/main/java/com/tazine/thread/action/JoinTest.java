package com.tazine.thread.action;

/**
 * 线程的插队
 *
 * @author frank
 * @since 1.0.0
 */
public class JoinTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new EmergencyCar());
        thread.start();

        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("正常情况：" + i + " 号车出发");

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EmergencyCar implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" 紧急情况：" + i + " 号车出发");
        }
    }
}