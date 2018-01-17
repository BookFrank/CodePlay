package com.tazine.thread.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定线程池
 *
 * @author frank
 * @since 1.0.0
 */
public class FixedThreadPool {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            exec.execute(new PrinterThread());
        }
        exec.shutdown();
    }
}
