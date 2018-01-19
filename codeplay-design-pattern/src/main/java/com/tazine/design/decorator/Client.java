package com.tazine.design.decorator;

/**
 * Client
 *
 * @author frank
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {

        Component component = new ConcreteComponent();

        Decorator decorator = new ConcreteDecorator(component);

        decorator.operation();

    }


}
