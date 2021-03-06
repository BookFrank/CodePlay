package com.tazine.thread.sync.unstable;

/**
 * VolatileTest
 *
 * @author frank
 * @date 2017/8/31
 */
public class VolatileTest {


    private static volatile boolean runFlag = true;


    public static void main(String[] args) {

        new Thread() {
            @Override
            public void run() {
                for (; ; ) {
                    if (runFlag == !runFlag) {
                        System.out.println("标志的状态改变了");
                        System.exit(0);
                    }
                }
            }
        }.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread() {
            @Override
            public void run() {
                for (; ; ) {
                    runFlag = !runFlag;
                }
            }
        }.start();
    }
}
