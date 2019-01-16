package com.tazine.design.flyweight;

import lombok.Data;

/**
 * Circle
 *
 * @author frank
 * @date 2019/1/13
 */
@Data
public class Circle implements Shape {

    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
    }
}
