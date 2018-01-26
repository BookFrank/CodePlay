package com.tazine.thread.concurrent.cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * AtomicityTest
 *
 * @author frank
 * @since 1.0.0
 */
public class AtomicityTest implements Runnable {

    private int i = 0;

    public int getVal() {
        return i;
    }

    private synchronized void increment() {
        ++i;
        ++i;
    }

    @Override
    public void run() {
        while (true) {
            increment();
        }
    }

    public static void main(String[] args) {

        ExecutorService pool = Executors.newSingleThreadExecutor();
        AtomicityTest atomicity = new AtomicityTest();
        pool.execute(atomicity);

        while (true) {
            int v = atomicity.getVal();
            if (v % 2 != 0) {
                System.out.println(v + " is not even");
                System.exit(0);
            }
        }
        /**
         * 尽管return i;是原子性操作，但是缺少同步使得其数值可以在处于不稳定的中间状态时被读取。
         * 除此之外，由于 i 也不是 volatile 的，因此还存在可视性问题
         */
    }
}
