package com.tazine.thread.sync;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过同步实现的盘子
 * 利用线程中的while循环实现等待的目标
 *
 * @author frank
 * @since 1.0.0
 */
public class SyncPlate {

    private List<Object> eggs = new ArrayList<>();

    public synchronized void put() {
        if (eggs.size() == 0) {
            System.out.println("放入鸡蛋");
            eggs.add(new Object());
        }
    }

    public synchronized void get() {
        if (eggs.size() > 0) {
            System.out.println("-- 拿走鸡蛋");
            eggs.remove(0);
        }
    }

    public static void main(String[] args) {

        SyncPlate syncPlate = new SyncPlate();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    syncPlate.put();
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    syncPlate.get();
                }
            }
        }.start();
    }
}
