package com.tazine.design.factory.abstraction;

import com.tazine.design.factory.abstraction.product.Color;
import com.tazine.design.factory.abstraction.product.Green;
import com.tazine.design.factory.abstraction.product.Shape;
import com.tazine.design.factory.abstraction.product.Yellow;

/**
 * Color Factory
 *
 * @author frank
 * @since 1.0.0
 */
public class ColorFactory extends AbstractFactory {
    @Override
    Color getColor(String name) {
        Color color = null;
        if (name.equalsIgnoreCase("yellow")) {
            color = new Yellow();
        } else if (name.equalsIgnoreCase("green")) {
            color = new Green();
        }
        return color;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}
