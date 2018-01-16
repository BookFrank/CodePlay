package com.tazine.design.strategy;

import com.tazine.design.strategy.family.FlyingWithPlane;

/**
 * 唐老鸭
 *
 * @author frank
 * @since 1.0.0
 */
public class DonaldDuck extends Duck {

    public DonaldDuck() {
        super();
        super.setFlyingStrategy(new FlyingWithPlane());
    }

    @Override
    public void quark() {
        System.out.println("唐老鸭，呱呱呱。。。");
    }

    @Override
    protected void display() {
        System.out.println("我是唐老鸭");
    }
}
