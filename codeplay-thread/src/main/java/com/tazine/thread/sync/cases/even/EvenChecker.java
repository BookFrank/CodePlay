package com.tazine.thread.sync.cases.even;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * EvenChecker
 *
 * @author frank
 * @date 2018/1/17
 */
public class EvenChecker implements Runnable {

    private IntGenerator generator;

    public EvenChecker(IntGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " is not even");
                generator.cancel();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        IntGenerator intGenerator = new EvenGenerator();
        IntGenerator mutexGenerator = new MutexGenerator();
        for (int i = 0; i < 10; i++) {
            //pool.execute(new EvenChecker(intGenerator));
            pool.execute(new EvenChecker(mutexGenerator));
        }
        pool.shutdown();
    }
}
