package com.tazine.design.factory.abstraction.product;

/**
 * Triangle
 *
 * @author frank
 * @date 2017/12/22
 */
public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Triangle::draw() Method");
    }
}
