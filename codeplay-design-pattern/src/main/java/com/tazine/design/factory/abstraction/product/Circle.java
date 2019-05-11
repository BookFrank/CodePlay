package com.tazine.design.factory.abstraction.product;

/**
 * Circle
 *
 * @author frank
 * @date 2017/12/22
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() Method");
    }
}
