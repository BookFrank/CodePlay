package com.tazine.thread.lock.spinlock;

/**
 * 基于自旋锁的打印机
 *
 * @author frank
 * @date 2019/05/16
 */
public class SpinPrinter {

    private SpinLock spinLock = new SpinLock();

    public void print(String words){
        try {
            spinLock.lock();
            for (Character c : words.toCharArray()) {
                System.out.print(c);
                Thread.sleep(500);
            }
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            spinLock.unlock();
        }
    }
}
