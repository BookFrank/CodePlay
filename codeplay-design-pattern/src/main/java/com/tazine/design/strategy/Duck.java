package com.tazine.design.strategy;

/**
 * Abstract Class
 *
 * @author frank
 * @since 1.0.0
 */
public abstract class Duck {

    /**
     * 通过飞行策略，代理飞行行为
     */
    private FlyingStrategy flyingStrategy;

    public void setFlyingStrategy(FlyingStrategy flyingStrategy) {
        this.flyingStrategy = flyingStrategy;
    }

    /**
     * 通过策略模式提供新增功能
     */
    public void fly(){
        flyingStrategy.performFly();
    }

    public void quark(){
        System.out.println("嘎嘎嘎");
    }

    protected abstract void display();

}
