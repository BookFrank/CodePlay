package com.tazine.thread.sync;

/**
 * 展示 CPU 执行的乱序性
 *
 * @author frank
 * @since 1.0.0
 */
public class ThreadDisorder {

    public static void main(String[] args) {

        final Outputer outputer = new Outputer();

        String name1 = "tom";
        String name2 = "jerry";

        /**
         * 当一个线程执行 print() 方法时，获得同步锁，执行输出方法，
         * 恰好此时第二个线程也要执行输出方法，但发现同步锁没有被释放，第二个线程就会进入就绪队列，等待同步锁被释放
         */
        new Thread(){
            @Override
            public void run(){
                //outputer.print(name1);
                outputer.syncPrint(name1);
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                //outputer.print(name2);
                outputer.syncPrint(name2);
            }
        }.start();

    }
}

class Outputer {
    public void print(String name) {
        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(" ");
    }

    public synchronized void syncPrint(String words) {
        for (int i = 0; i < words.length(); i++) {
            System.out.print(words.charAt(i));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(" ");
    }
}
