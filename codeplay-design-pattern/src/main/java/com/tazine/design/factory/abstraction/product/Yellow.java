package com.tazine.design.factory.abstraction.product;

/**
 * Yellow
 *
 * @author frank
 * @since 1.0.0
 */
public class Yellow implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Yellow::fill() Method");
    }
}
