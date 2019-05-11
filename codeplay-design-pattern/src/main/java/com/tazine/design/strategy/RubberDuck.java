package com.tazine.design.strategy;

import com.tazine.design.strategy.family.FlyingNoWay;

/**
 * RubberDuck
 *
 * @author frank
 * @date 2018/01/15
 */
public class RubberDuck extends Duck{

    public RubberDuck() {
        super();
        super.setFlyingStrategy(new FlyingNoWay());
    }

    @Override
    protected void display() {
        System.out.println("我是一只黄色的橡胶鸭...");
    }
}
