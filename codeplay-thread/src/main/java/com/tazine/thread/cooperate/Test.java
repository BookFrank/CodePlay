package com.tazine.thread.cooperate;

import com.tazine.thread.App;

public class Test {

    public static void main(String[] args) {
        new Thread(new Thread01()).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Thread02()).start();
    }


    private static class Thread01 implements Runnable {
        @Override
        public void run() {
            synchronized (App.class) {
                System.out.println("Entered thread01");
                System.out.println("Thread01 is waiting");

                try {
                    App.class.wait();
                    //wait();
                    //Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread01 has been notified");
                System.out.println("Thread01 is over");
            }
        }
    }

    private static class Thread02 implements Runnable {
        @Override
        public void run() {
            synchronized (App.class) {
                System.out.println("-----Entered thread02");
                System.out.println("-----Thread02 is sleep");
                /**
                 * 尽管调用notify()，但此时 App.class的同步锁还在，等待线程2执行完毕
                 * 释放同步锁，被唤醒的线程1才会执行。
                 */
                App.class.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-----Thread02 sleep end");
                System.out.println("-----Thread02 is over");
            }
        }
    }
}
