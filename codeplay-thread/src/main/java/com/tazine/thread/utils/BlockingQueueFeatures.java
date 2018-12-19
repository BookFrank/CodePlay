package com.tazine.thread.utils;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueue
 *
 * @author frank
 * @date 2017/12/20
 */
public class BlockingQueueFeatures {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new AddThread(queue)).start();
        }
        for (int j = 0; j < 10; j++) {
            new Thread(new FetchThread(queue)).start();
        }
    }
}

class AddThread implements Runnable {

    private BlockingQueue<Integer> bkQueue;

    public AddThread(BlockingQueue<Integer> bkQueue) {
        this.bkQueue = bkQueue;
    }

    @Override
    public void run() {
        try {
            /*
                put() 为阻塞调用，当队列满时将会阻塞
             */
            bkQueue.put(new Random().nextInt(20));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 存入数字");
    }
}

class FetchThread implements Runnable {
    private BlockingQueue<Integer> bkQueue;

    public FetchThread(BlockingQueue<Integer> bkQueue) {
        this.bkQueue = bkQueue;
    }

    @Override
    public void run() {
        try {
            /*
                take() 为阻塞调用，队列空时将会阻塞
             */
            System.out.println(Thread.currentThread().getName() + " 取出数字" + bkQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
