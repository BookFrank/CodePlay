package com.tazine.thread.action;

/**
 * Thread.yield()：可以将CPU从当前线程转移给另一个线程
 * 使当前线程从执行状态（运行状态）变为可执行态（就绪状态）
 *
 * @author frank
 * @date 2018/07/26
 */
public class YieldFuncDemo {

    public static void main(String[] args) throws InterruptedException {
        YieldThread yt1 = new YieldThread("hello");
        YieldThread yt2 = new YieldThread("--world");
        yt1.start();
        yt2.start();
    }

}


class YieldThread extends Thread {

    public YieldThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("" + this.getName() + "-----" + i);
            // 当i为30时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            if (i == 30) {
                Thread.yield();
            }
        }
    }
}
