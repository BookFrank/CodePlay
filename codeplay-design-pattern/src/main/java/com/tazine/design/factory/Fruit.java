package com.tazine.design.factory;

/**
 * Created by lina on 2017/12/21.
 */
public class Fruit {
    protected String name;

    public Fruit(String name) {
        this.name = name;
    }

    public void sayName() {
        System.out.println(name);
    }
}
