package com.tazine.thread.sync.cases.producer.condition;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class ConsumerThread extends Thread {

    private MyService service;

    public ConsumerThread(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        while (true){
            try {
                service.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
