package com.tazine.jvm.exception;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * CPU 使用率过高
 *
 * @author frank
 * @date 2019/01/26
 */
public class CpuExhaustion {

    private static Executor executor = Executors.newFixedThreadPool(4);

    private static Object lock = new Object();

    public static void main(String[] args) {
        Task task1 = new Task();
        Task task2 = new Task();

        executor.execute(task1);
        executor.execute(task2);
    }

    private static class Task implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                doBusiness();
            }
        }

        public void doBusiness(){
            int i = 0;
            while (true){
                i++;
            }
        }
    }
}
