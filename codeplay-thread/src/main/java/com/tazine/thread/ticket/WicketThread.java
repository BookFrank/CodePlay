package com.tazine.thread.ticket;

/**
 * 采用 Thread 方式的售票窗口线程
 * @author Frank
 */
public class WicketThread extends Thread{

    private int leftTicketNum = 5;

    public WicketThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (leftTicketNum > 0){
            leftTicketNum--;
            System.out.println(Thread.currentThread().getName() + " 卖出一张，还剩 " + leftTicketNum);
        }
    }
}
