package com.tazine.thread.lock.spinlock;

/**
 * 基于自旋锁的锁重入
 *
 * @author frank
 * @date 2019/05/17
 */
public class ReSpinLock {

    private SpinLock lock = new SpinLock();

    public void a() {
        try {
            lock.lock();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " 执行 a 方法");
            b();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void b() {
        try {
            lock.lock();
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName() + " 执行 b 方法");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
