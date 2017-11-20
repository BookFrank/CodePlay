package com.tazine.thread.ticket;

/**
 * Runable 和 Thread 创建线程的区别
 * @author Frank
 */
public class RunableVsThread {


    public static void main(String[] args) {

        new WicketThread("窗口01").start();
        new WicketThread("窗口02").start();
        new WicketThread("窗口03").start();
        new WicketThread("窗口04").start();

        WicketRunable runable = new WicketRunable();

        new Thread(runable, "窗口-01").start();
        new Thread(runable, "窗口-02").start();
        new Thread(runable, "窗口-03").start();
        new Thread(runable, "窗口-04").start();

    }


}
