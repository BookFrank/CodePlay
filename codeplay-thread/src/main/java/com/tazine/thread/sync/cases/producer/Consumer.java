package com.tazine.thread.sync.cases.producer;

import java.util.List;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class Consumer {

    private Object object;

    private List<Integer> list;

    public Consumer(Object object, List<Integer> list) {
        this.object = object;
        this.list = list;
    }

    public void consume() throws InterruptedException {
        synchronized (object){

            while (list.isEmpty()){
                object.wait();
            }
            int i = list.get(0);
            System.out.println("消费者消费 " + i);
            list.remove(0);
            object.notify();
        }
    }
}
