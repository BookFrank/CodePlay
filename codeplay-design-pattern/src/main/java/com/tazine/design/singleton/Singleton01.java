package com.tazine.design.singleton;

/**
 * 懒汉式单例：非线程安全
 *
 * @author frank
 * @since 1.0.0
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
