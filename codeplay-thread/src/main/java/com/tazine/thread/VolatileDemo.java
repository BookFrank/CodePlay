package com.tazine.thread;

/**
 * Volatile关键词：能够实现可见性，但是无法实现原子性
 *
 * @author frank
 * @date 2018/02/26
 */
public class VolatileDemo {

    private volatile static int result = 10;

    public static void main(String[] args) {

        int i = 10;
        while (i-- > 0) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "-当前result值为" + result);
                    result--;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


    }


}
