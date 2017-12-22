package com.tazine.design.factory.simple;

/**
 * 简单工厂
 *
 * @author frank
 * @since 1.0.0
 */
public class SimpleFactory {

    public static Fruit getFruit(String fruitName) {

        Fruit fruit = null;
        if (fruitName.equalsIgnoreCase("apple")) {
            fruit = new Apple("Apple", "California", 1.0);
        } else if (fruitName.equalsIgnoreCase("banana")) {
            fruit = new Banana("Banana", "Thailand", 5.2);
        }
        return fruit;
    }
}
