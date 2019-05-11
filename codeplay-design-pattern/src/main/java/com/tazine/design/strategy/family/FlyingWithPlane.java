package com.tazine.design.strategy.family;

import com.tazine.design.strategy.FlyingStrategy;

/**
 * FlyingStrategy Impl
 *
 * @author frank
 * @date 2018/01/15
 */
public class FlyingWithPlane implements FlyingStrategy {
    @Override
    public void performFly() {
        System.out.println("坐飞机飞行");
    }
}
