package com.tazine.design.factory.abstraction;

import com.tazine.design.factory.abstraction.product.Circle;
import com.tazine.design.factory.abstraction.product.Color;
import com.tazine.design.factory.abstraction.product.Shape;
import com.tazine.design.factory.abstraction.product.Triangle;

/**
 * Shape Factory
 *
 * @author frank
 * @since 1.0.0
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    Color getColor(String name) {
        return null;
    }

    @Override
    Shape getShape(String shapeName) {
        Shape shape = null;
        if (shapeName.equalsIgnoreCase("circle")){
            shape = new Circle();
        }else if (shapeName.equalsIgnoreCase("triangle")){
            shape = new Triangle();
        }
        return shape;
    }
}
