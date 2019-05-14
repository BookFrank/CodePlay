package com.tazine.design.factory.abstraction.product;

/**
 * Green
 *
 * @author frank
 * @date 2017/12/22
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() Method");
    }
}
