package com.tazine.design.singleton;

/**
 * 静态语句块创建单例
 *
 * @author frank
 * @date 2017/8/10
 */
public class Singleton04 {

    private static Singleton04 instance;

    static {
        instance = new Singleton04();
    }

    private Singleton04() {
    }

    public static Singleton04 getInstance() {
        return instance;
    }
}
