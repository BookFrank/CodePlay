package com.tazine.thread.lock.synchron;

/**
 * 使用 synchronized 的打印机
 *
 * @author frank
 * @date 2019/05/16
 */
public class SynchronicPrinter {

    public synchronized void print(String words) {
        try {
            for (Character c : words.toCharArray()) {
                System.out.print(c);
                Thread.sleep(500);
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
