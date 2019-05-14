package com.tazine.design.singleton;

/**
 * 线程安全的懒汉式单例
 *
 * @author frank
 * @date 2017/8/10
 */
public class Singleton03 {

    private static Singleton03 instance;

    private Singleton03() {}

    public synchronized static Singleton03 getInstance() {
        if (null == instance) {
            instance = new Singleton03();
        }
        return instance;
    }
}
