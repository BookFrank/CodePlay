package com.tazine.thread.sync.cases.producer;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class ProducerThread extends Thread{

    private Producer producer;

    public ProducerThread(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true){
            try {
                producer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
