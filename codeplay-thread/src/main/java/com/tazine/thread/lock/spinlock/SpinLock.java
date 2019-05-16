package com.tazine.thread.lock.spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 *
 * @author frank
 * @date 2019/05/16
 */
public class SpinLock {

    private AtomicReference<Thread> lock = new AtomicReference<>();

    /**
     * lock() 将 owner 设置为当前线程，并且预测原来值为空
     */
    public void lock(){
        Thread current = Thread.currentThread();

        // 当有第二个线程调用lock操作室由于owner至不为空，导致循环一直被执行，直至owner线程调用unlock释放锁
        while (!lock.compareAndSet(null, current)){
            System.out.println("我一直在等待锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将 owner 设置为 NULL，并且预测值为当前线程
     */
    public void unlock(){
        Thread current = Thread.currentThread();
        lock.compareAndSet(current, null);
    }
}
