package com.tazine.design.strategy;

import com.tazine.design.strategy.family.FlyingNoWay;

/**
 * RubberDuck
 *
 * @author frank
 * @since 1.0.0
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
