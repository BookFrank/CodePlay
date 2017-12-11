package com.tazine.base.reflect;

/**
 *
 */
public class NbaPlayer implements BrandInterface{

    private String name;
    private int age;

    public NbaPlayer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void play(){
        System.out.println(this.name + " 可以打篮球");
    }

    @Override
    public void getBrand() {
        System.out.println(this.name + " 是 " + BrandInterface.NAME + "旗下的球员");
    }
}
