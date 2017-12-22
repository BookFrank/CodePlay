package com.tazine.design.factory.simple;

/**
 * Banana实体类
 *
 * @author frank
 * @since 1.0.0
 */
public class Banana implements Fruit {

    private String name;
    private String area;
    private double price;

    public Banana(String name, String area, double price) {
        this.name = name;
        this.area = area;
        this.price = price;
    }

    @Override
    public void info() {
        System.out.println(name + " from " + area);
    }

    @Override
    public void price() {
        System.out.println(name + ", price is  " + price);
    }
}
