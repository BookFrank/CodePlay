package com.tazine.thread.concurrent.lock.dead;

import java.util.concurrent.TimeUnit;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @since 1.0.0
 */
public class DeadLockDemo {

    public static String obj1 = "obj1";
    public static String obj2 = "obj2";

    public static void main(String[] args) {

        new Thread(new LockA()).start();
        new Thread(new LockB()).start();
    }

}

class LockA implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("LockA 开始执行");
            while (true) {
                synchronized (DeadLockDemo.obj1) {
                    System.out.println("LockA 锁住了 obj1");
                    // 给 LockB 机会去锁住 obj2
                    Thread.sleep(3000);
                    synchronized (DeadLockDemo.obj2) {
                        System.out.println("LockA 锁住了 obj2");
                        // 测试使用，拿到锁就不释放
                        TimeUnit.DAYS.sleep(1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class LockB implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("-- LockB 开始执行");
            synchronized (DeadLockDemo.obj2) {
                System.out.println("-- LockB 锁住了 obj2");
                Thread.sleep(3000);
                synchronized (DeadLockDemo.obj1) {
                    System.out.println("-- LockB 锁住了 obj1");
                    TimeUnit.DAYS.sleep(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}