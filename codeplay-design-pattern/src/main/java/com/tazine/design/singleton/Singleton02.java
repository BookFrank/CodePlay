package com.tazine.design.singleton;

/**
 * 饿汉式单例：线程安全
 *
 * @author frank
 * @date 2017/8/10
 */
public class Singleton02 {

    private static Singleton02 instance = new Singleton02();

    private Singleton02() {
    }

    public static Singleton02 getInstance() {
        if (null == instance) {
            instance = new Singleton02();
        }
        return instance;
    }
}
