package com.tazine.design.decorator;

/**
 * ConcreteDecorator
 *
 * @author frank
 * @since 1.0.0
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        before();
        super.operation();
        after();
    }

    private void after() {
        System.out.println("Decorator: before");
    }

    private void before() {
        System.out.println("Decorator: after");
    }
}
