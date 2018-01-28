package com.tazine.thread.sync.cases.producer.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        new ConsumerThread(queue).start();
        new ProduceThread(queue).start();

    }

}
