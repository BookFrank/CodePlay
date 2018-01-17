package com.tazine.thread.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Locks in the concurrent library allow you
 * to give up on trying to acquire a lock.
 *
 * @author frank
 * @since 1.0.0
 */
public class AttemptLocking {

    private Lock lock = new ReentrantLock();

    public void untimed(){

        boolean flag = lock.tryLock();
        try {
            System.out.println("untimed 获取锁 ：" + flag);
        } finally {
            if (flag){
                lock.unlock();
            }
        }
    }

    public void timed(){
        boolean flag = false;
        try {
            flag = lock.tryLock(2, TimeUnit.SECONDS);
            System.out.println("timed 获取锁 ： " + flag);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (flag){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {

        AttemptLocking attempt = new AttemptLocking();

        attempt.untimed(); // true
        attempt.timed(); // true

        new Thread(){
            {setDaemon(true);}
            @Override
            public void run() {
                attempt.lock.lock();
            }
        }.start();

        // give the thread above chance to run
        Thread.yield();

        attempt.untimed(); // false
        attempt.timed(); // false

        /**
         * ReentrantLock 允许你尝试获取但最终未获取锁，这样如果其他人已经获取了这个锁，
         * 那该线程就可以执行一些别的事情，而不是等待直至这个锁被释放。
         * 显式的Lock对象在加锁和释放锁方面，相对于内奸的synchronized锁来说，
         * 还赋予了你更细粒度的控制力，这对于实现专有同步结构是很有用的。
         */
    }
}
