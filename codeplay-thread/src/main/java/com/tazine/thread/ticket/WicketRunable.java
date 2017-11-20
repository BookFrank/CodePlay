package com.tazine.thread.ticket;

/**
 * 采用 Runable 方式的售票窗口线程
 * @author Frank
 */
public class WicketRunable implements Runnable {

    private int leftTicketNum = 5;

    @Override
    public void run() {
        while (leftTicketNum > 0){
            leftTicketNum--;
            System.out.println(Thread.currentThread().getName() + " 卖出一张，还剩 " + leftTicketNum);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
