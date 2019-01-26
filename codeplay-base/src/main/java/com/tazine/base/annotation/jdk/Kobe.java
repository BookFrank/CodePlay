package com.tazine.base.annotation.jdk;

/**
 * JDK中 @Override 注解用法
 *
 * @author frank
 * @date 2017/12/15
 */
public class Kobe implements Player {
    @Override
    public String name() {
        return "kobe";
    }

    @Override
    public int age() {
        return 20;
    }

    @Override
    public double height() {
        return 1.98;
    }

    @Override
    public void care() {
        System.out.println("Kobe 参加NBA关怀行动");
    }
}
