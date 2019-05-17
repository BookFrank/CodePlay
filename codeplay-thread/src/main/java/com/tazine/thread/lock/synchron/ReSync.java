package com.tazine.thread.lock.synchron;

/**
 * ReSync
 *
 * @author frank
 * @date 2019/05/17
 */
public class ReSync {

    public synchronized void a(){
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "执行 a 方法");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void b(){
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "执行 b 方法");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
