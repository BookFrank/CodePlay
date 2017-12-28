package com.tazine.jvm.memory;

/**
 * Volatile 能保证同步，不能保证原子
 *
 * @author frank
 * @since 1.0.0
 */
public class VolatileTest {

    private static final int THREADS_COUNT = 20;

    public static volatile int race = 0;

    public static int syn = 0;

    public static void increase() {
        race++;
    }

    public synchronized static void incr() {
        syn++;
    }

    public static void main(String[] args) {

        Thread[] threads = new Thread[THREADS_COUNT];
        for (Thread thread : threads) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                        incr();
                    }
                }
            });
            thread.start();
        }
        // 等待所有累加线程都结束(这里2是因为编辑器会有一个监控 ctrl-break线程)
        while (Thread.activeCount() > 2) {
            //System.out.println(Thread.activeCount());
            Thread.yield();
        }
        System.out.println(race);
        System.out.println(syn);
    }
}
