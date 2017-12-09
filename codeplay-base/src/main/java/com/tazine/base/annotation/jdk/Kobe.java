package com.tazine.base.annotation.jdk;

/**
 * JDK中 @Override 注解用法
 *
 * @author Frank
 * @since 1.0.0
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
