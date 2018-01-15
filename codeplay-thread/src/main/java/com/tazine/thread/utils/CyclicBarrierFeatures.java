package com.tazine.thread.utils;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * CyclicBarrier：循环屏障
 *
 * @author frank
 * @since 1.0.0
 */
public class CyclicBarrierFeatures {

    private static final int THREAD_NUMBER = 3;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(THREAD_NUMBER, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有的小伙伴都出色的完成了自己的任务，一起哈啤。");
            }
        });

        for (int i = 1; i < 4; i++) {
            new Worker(i, barrier, RANDOM).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("-----------CyclicBarrier 重用----------");
        for (int i = 1; i < 4; i++) {
            new Worker(i, barrier, RANDOM).start();
        }
    }
}

class Worker extends Thread {

    private int id;
    private CyclicBarrier barrier;
    private Random random;

    public Worker(int id, CyclicBarrier barrier, Random random) {
        this.id = id;
        this.barrier = barrier;
        this.random = random;
    }

    @Override
    public void run() {
        int sec = random.nextInt(10);
        System.out.println(id + "号线程还需要 " + sec + "s 时间");
        try {
            sleep(sec * 1000);
            System.out.println(id + "号线程完成任务，等待其他小伙伴");

            // 发生超时异常时，还没完成任务的线程在完成任务之后不会做任何等待，而是直接执行后续的操作
            barrier.await(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(id + " 小伙伴们都完成了任务。");
    }
}
