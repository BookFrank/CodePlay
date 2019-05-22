package com.tazine.thread.lock.synchron;

import com.tazine.thread.lock.spinlock.ReSpinLock;

/**
 * Test
 *
 * @author frank
 * @date 2019/05/17
 */
public class Test {

    public static void main(String[] args) {

        // 可重入情况
        //ReSync reSync = new ReSync();
        //new Thread(() -> reSync.a()).start();
        //new Thread(() -> reSync.a()).start();

        // 不可重入情况
        ReSpinLock reSpinLock = new ReSpinLock();
        new Thread(() -> reSpinLock.a()).start();
        new Thread(() -> reSpinLock.a()).start();
    }
}
