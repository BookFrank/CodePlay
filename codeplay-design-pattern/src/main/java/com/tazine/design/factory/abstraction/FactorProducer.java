package com.tazine.design.factory.abstraction;

/**
 * Factory Producer
 *
 * @author frank
 * @since 1.0.0
 */
public class FactorProducer {

    public static AbstractFactory getFactory(String name) {
        AbstractFactory factory = null;
        if (name.equalsIgnoreCase("shape")) {
            factory = new ShapeFactory();
        } else if (name.equalsIgnoreCase("color")) {
            factory = new ColorFactory();
        }
        return factory;
    }
}
