package com.tazine.thread.concurrent.threadlocal.cases.connection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lina on 2018/1/8.
 *
 * @author frank
 * @since 1.0.0
 */
public class Test {


    public static void main(String[] args) {

        ClientThread client = new ClientThread();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        for (int i=0;i<10;i++){
            pool.submit(client);
        }

        pool.shutdown();

    }

}
