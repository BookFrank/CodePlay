package com.tazine.design.strategy.family;

import com.tazine.design.strategy.FlyingStrategy;

/**
 * Created by lina on 2018/1/15.
 *
 * @author frank
 * @since 1.0.0
 */
public class FlyingWithPlane implements FlyingStrategy {
    @Override
    public void performFly() {
        System.out.println("坐飞机飞行");
    }
}
