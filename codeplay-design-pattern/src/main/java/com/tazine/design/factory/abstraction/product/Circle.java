package com.tazine.design.factory.abstraction.product;

/**
 * Circle
 *
 * @author frank
 * @since 1.0.0
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() Method");
    }
}
