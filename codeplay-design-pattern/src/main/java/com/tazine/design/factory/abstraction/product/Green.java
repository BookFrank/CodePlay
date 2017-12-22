package com.tazine.design.factory.abstraction.product;

/**
 * Green
 *
 * @author frank
 * @since 1.0.0
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() Method");
    }
}
