package com.tazine.design.strategy.family;

import com.tazine.design.strategy.FlyingStrategy;

/**
 * 通过算法家族实现，兼容不具备该功能的对象
 *
 * @author frank
 * @since 1.0.0
 */
public class FlyingNoWay implements FlyingStrategy {
    @Override
    public void performFly() {
        System.out.println("我不会飞行");
    }
}
