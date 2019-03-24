package com.tazine.thread.sync.cases.producer.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Client
 *
 * @author frank
 * @date 2018/1/28
 */
public class Client {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        new ConsumerThread(queue).start();
        new ProduceThread(queue).start();

    }

}
