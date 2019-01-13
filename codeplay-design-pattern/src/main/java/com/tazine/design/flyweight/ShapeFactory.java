package com.tazine.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * ShapeFactory
 *
 * @author frank
 * @date 2019/1/13
 */
public class ShapeFactory {

    private static final Map<String, Shape> circleMap = new HashMap<>();

    public static Circle getCircle(String color){
        Circle circle = (Circle) circleMap.get(color);

        if (null == circle){
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("工厂中不存在，制造一个 " + color);
        }
        return circle;
    }
}
