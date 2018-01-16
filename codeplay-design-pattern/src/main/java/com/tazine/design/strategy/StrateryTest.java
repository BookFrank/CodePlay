package com.tazine.design.strategy;

/**
 * 策略测试类
 *
 * @author frank
 * @since 1.0.0
 */
public class StrateryTest {

    public static void main(String[] args) {

        // 正常的鸭子
        Duck yellowDuck = new YellowDuck();
        yellowDuck.display();
        yellowDuck.quark();
        yellowDuck.fly();
        System.out.println();

        // 唐老鸭
        Duck donald = new DonaldDuck();
        donald.display();
        donald.quark();
        donald.fly();
        System.out.println();

        // 橡胶鸭，通过策略家族算法实现兼容不具备该功能的对象
        Duck rubDuck = new RubberDuck();
        rubDuck.display();
        rubDuck.quark();
        rubDuck.fly();
    }
}
