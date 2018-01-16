package com.tazine.thread.cooperate;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过线程通信实现的盘子
 * 在调用 wait() 方法时，都是用while来判断条件，而不是if，也推荐使用while，
 * 因为在某些情况下，线程有可能会被假唤醒，使用while循环监测更好。
 * wait() 和 notify() 必须工作于 synchronized 内部，且这两个方法只能由锁对象调用
 *
 * @author frank
 * @since 1.0.0
 */
public class CooperPlate {

    private List<Object> eggs = new ArrayList<>();

    /**
     * 不加 synchronized 时会报下面错误，
     * Exception in thread "Thread-0" java.lang.IllegalMonitorStateException
     *
     * @throws InterruptedException
     */
    public synchronized void put() throws InterruptedException {
        while (eggs.size() > 0) {
            wait();
        }
        System.out.println("放入鸡蛋");
        eggs.add(new Object());
        notify();
    }

    public synchronized void get() throws InterruptedException {
        while (eggs.size() == 0) {
            wait();
        }
        System.out.println("-- 拿走鸡蛋");
        eggs.remove(0);
        notify();
    }

    public static void main(String[] args) {

        CooperPlate plate = new CooperPlate();

        new Thread() {
            @Override
            public void run() {
                try {
                    plate.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    plate.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
