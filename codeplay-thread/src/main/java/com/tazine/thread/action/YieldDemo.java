package com.tazine.thread.action;

/**
 * Thread.yield()：可以将CPU从当前线程转移给另一个线程
 *
 * @author frank
 * @date 2018/07/26
 */
public class YieldDemo {

    public static void main(String[] args) {
        YieldThread thread = new YieldThread();
        thread.start();
    }

}


class YieldThread extends Thread {
    @Override
    public void run() {
        System.out.println("YieldThread 正在执行......");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        yield();
    }
}
