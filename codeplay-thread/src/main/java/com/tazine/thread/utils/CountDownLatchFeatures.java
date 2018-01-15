package com.tazine.thread.utils;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch：倒计时锁存器
 * 是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行。
 * 例如，应用程序的主线程希望在负责启动框架服务的线程已经启动所有的框架服务之后再执行
 *
 * @author frank
 * @since 1.0.0
 */
public class CountDownLatchFeatures {

    private static final int RUNNER_NUMBER = 3;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws InterruptedException {

        // 用来判断运动员是否准备好
        CountDownLatch readyLatch = new CountDownLatch(RUNNER_NUMBER);

        // 用来判断裁判是否发令
        CountDownLatch startLatch = new CountDownLatch(1);

        new Runner(1, readyLatch, startLatch, RANDOM).start();
        new Runner(2, readyLatch, startLatch, RANDOM).start();
        new Runner(3, readyLatch, startLatch, RANDOM).start();
        readyLatch.await();
        System.out.println();
        System.out.println("裁判：All Set");
        int s = RANDOM.nextInt(10);
        System.out.println("裁判正在掏枪，还需要 " + s + " s");
        Thread.sleep(s * 1000);
        startLatch.countDown();
        System.out.println("Biu......");
    }
}

class Runner extends Thread {

    private int playerNum;
    private CountDownLatch readyLatch;
    private CountDownLatch startLatch;
    private Random random;

    public Runner(int num, CountDownLatch readyLatch, CountDownLatch startLatch, Random random) {
        this.playerNum = num;
        this.readyLatch = readyLatch;
        this.startLatch = startLatch;
        this.random = random;
    }

    @Override
    public void run() {
        int sec = random.nextInt(10);
        System.out.println(playerNum + "号选手，还需要 " + sec + "s 时间");
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(playerNum + "号选手，准备好了！");
        readyLatch.countDown();
        try {
            startLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(playerNum + "号选手开跑...");
    }
}
