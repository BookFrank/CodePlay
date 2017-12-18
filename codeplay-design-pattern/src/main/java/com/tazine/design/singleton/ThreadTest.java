package com.tazine.design.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lina on 2017/12/18.
 */
public class ThreadTest extends Thread {

    @Override
    public void run() {
        System.out.println(Singleton03.getInstance().hashCode());
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0;i<10;i++){
            exec.execute(new ThreadTest());
        }
        exec.shutdown();
    }
}
