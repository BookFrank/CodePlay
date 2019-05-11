package com.tazine.design.factory.abstraction.product;

/**
 * Yellow
 *
 * @author frank
 * @date 2017/12/22
 */
public class Yellow implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Yellow::fill() Method");
    }
}
