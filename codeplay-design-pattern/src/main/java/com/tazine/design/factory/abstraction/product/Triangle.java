package com.tazine.design.factory.abstraction.product;

/**
 * Triangle
 *
 * @author frank
 * @since 1.0.0
 */
public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Triangle::draw() Method");
    }
}
