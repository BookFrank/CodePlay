package com.tazine.blockQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ly on 2017/8/31.
 */
public class Test {


    public static void main(String[] args) {

        // 声明一个容量为5的阻塞队列
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(5);

        // 实例化3个生产者和一个消费者
        Producer producer01 = new Producer(queue);
        Producer producer02 = new Producer(queue);
        Producer producer03 = new Producer(queue);
        Consumer consumer = new Consumer();










    }



}
