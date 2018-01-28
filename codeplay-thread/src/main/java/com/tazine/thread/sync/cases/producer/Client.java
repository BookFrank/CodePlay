package com.tazine.thread.sync.cases.producer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class Client {


    public static void main(String[] args) {

        Object obj = new Object();

        List<Integer> list = new ArrayList<>();

        Producer producer = new Producer(obj, list);
        Consumer consumer = new Consumer(obj, list);

        new ProducerThread(producer).start();
        new ConsumerThread(consumer).start();


    }

}
