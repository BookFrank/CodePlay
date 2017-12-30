package com.tazine.thread.blockQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by ly on 2017/8/31.
 */
public class Producer implements Runnable{

    private boolean isRunning;

    private BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run()
    {
        String data = null;
        Random r  = new Random();

        System.out.println("启动生产者线程");

        try {
            while (isRunning){

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
