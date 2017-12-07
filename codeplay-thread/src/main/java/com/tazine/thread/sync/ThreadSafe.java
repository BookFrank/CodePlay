package com.tazine.thread.sync;

/**
 * 同步块 & 同步方法
 *
 * @author Frank
 */
public class ThreadSafe {
    public static void main(String[] args) {
        // Window window = new Window();

        Window01 window = new Window01();

        Thread thread01 = new Thread(window, "窗口01");
        Thread thread02 = new Thread(window, "窗口02");
        Thread thread03 = new Thread(window, "窗口03");

        thread01.start();
        thread02.start();
        thread03.start();
    }
}

/**
 * 同步块实现
 */
class Window implements Runnable {

    private int tickets = 5;

    public void run() {
        while (true) {
            synchronized ("") {
                if (tickets > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 卖出一张，还剩：" + --tickets);
                }
            }
        }
    }
}

/**
 * 同步方法实现
 */
class Window01 implements Runnable {

    private int tickets = 5;

    private synchronized void sell() {
        if (tickets > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 卖出一张，还剩：" + --tickets);
        }
    }

    public void run() {
        while (true) {
            sell();
        }
    }
}
