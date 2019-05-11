package com.tazine.design.factory.simple;

/**
 * 使用工厂类得到实例
 *
 * @author frank
 * @date 2017/12/22
 */
public class Customer {

    public static void main(String[] args) {

        // 客户想买苹果，但并不用关心苹果是怎么生产的。
        Fruit apple = SimpleFactory.getFruit("apple");
        apple.info();
        apple.price();

        System.out.println();
        Fruit banana = SimpleFactory.getFruit("banana");
        banana.info();
        banana.price();
    }
}
