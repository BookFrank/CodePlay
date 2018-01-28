package com.tazine.thread.sync.cases.producer;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class ConsumerThread extends Thread {


    private Consumer consumer;

    public ConsumerThread(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while (true){
            try {
                consumer.consume();
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
