package com.tazine.base.reflect;

/**
 * NbaPlayer
 *
 * @author frank
 * @date 2017/12/5
 */
public class NbaPlayer implements BrandInterface{

    private String name;
    private int age;

    private void play(){
        System.out.println(this.name + " 可以打篮球");
    }

    @Override
    public void getBrand() {
        System.out.println(this.name + " 是 " + BrandInterface.NAME + "旗下的球员");
    }
}
