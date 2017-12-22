package com.tazine.design.factory.abstraction;

import com.tazine.design.factory.abstraction.product.Color;
import com.tazine.design.factory.abstraction.product.Shape;

/**
 * 抽象工厂模式：消费者
 *
 * @author frank
 * @since 1.0.0
 */
public class Customer {

    public static void main(String[] args) {

        Shape circle = FactorProducer.getFactory("shape").getShape("circle");
        circle.draw();

        Shape triangle = FactorProducer.getFactory("shape").getShape("triangle");
        triangle.draw();

        Color yellow = FactorProducer.getFactory("color").getColor("yellow");
        yellow.fill();

        Color green = FactorProducer.getFactory("color").getColor("green");
        green.fill();
    }
}
