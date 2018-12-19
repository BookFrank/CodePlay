package com.tazine.container.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * ConcurrentHashMap
 *
 * @author frank
 * @date 2018/1/11
 */
public class ConcurrentHashMapTest {

    private ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public synchronized void add(String key) {
        Integer v = map.get(key);
        if (null == v) {
            map.put(key, 1);
        } else {
            map.put(key, ++v);
        }
    }

    public static void main(String[] args) {
        ConcurrentHashMapTest test = new ConcurrentHashMapTest();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    test.add("hi");
                }
            }
        };

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test.map.get("hi"));

        /**
         * 结果 2971 ，即使使用线程安全的容器，但是外部所有对该容器访问的方法也要加锁
         */
    }
}
