package com.tazine.design.strategy;

import com.tazine.design.strategy.family.FlyingWithWings;

/**
 * 大黄鸭
 *
 * @author frank
 * @date 2018/01/15
 */
public class YellowDuck extends Duck {

    public YellowDuck() {
        super();
        super.setFlyingStrategy(new FlyingWithWings());
    }

    @Override
    protected void display() {
        System.out.println("我是大黄鸭");
    }
}
