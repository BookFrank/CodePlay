package com.tazine.thread.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger
 *
 * @author frank
 * @since 1.0.0
 */
public class AtomicIntegerFeature implements Runnable{

    /**
     * 使用 CAS 可以避免加锁
     */
    private AtomicInteger i = new AtomicInteger(0);

    private AtomicInteger getVal(){
        return i;
    }

    private void increment(){
        i.addAndGet(2);
    }

    @Override
    public void run() {
        while (true){
            increment();
        }
    }

    public static void main(String[] args) {

        AtomicIntegerFeature runnable = new AtomicIntegerFeature();

        new Thread(runnable).start();

        while (true){
            int val = runnable.i.get();
            if (val % 2 != 0){
                System.out.println(val + " is not enen");
                System.exit(0);
            }
        }
    }
}
