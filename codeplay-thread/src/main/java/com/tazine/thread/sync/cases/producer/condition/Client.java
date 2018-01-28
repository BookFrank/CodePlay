package com.tazine.thread.sync.cases.producer.condition;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {

        MyService service = new MyService();

        new ProducerThread(service).start();
        new ConsumerThread(service).start();

    }
}
