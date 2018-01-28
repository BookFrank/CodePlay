package com.tazine.thread.sync.cases.producer.block;

import java.util.concurrent.BlockingQueue;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class ConsumerThread extends Thread {

    private BlockingQueue<Integer> queue;

    public ConsumerThread(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            int i;
            try {
                i = queue.take();
                System.out.println("消费者消费 -- " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
