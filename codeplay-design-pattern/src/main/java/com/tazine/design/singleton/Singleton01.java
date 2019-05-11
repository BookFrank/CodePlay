package com.tazine.design.singleton;

/**
 * 懒汉式单例：非线程安全
 *
 * @author frank
 * @date 2017/8/10
 */
public class Singleton01 {

    private static Singleton01 instance;

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        if (null == instance) {
            instance = new Singleton01();
        }
        return instance;
    }
}
