package com.tazine.design.factory;

/**
 * Created by lina on 2017/12/21.
 */
public class Apple extends Fruit {

    public Apple(String name) {
        super(name);
    }


    public static void main(String[] args) {

        Apple apple = (Apple) FruitFactory.getFruit(1);
        apple.sayName();

    }
}
