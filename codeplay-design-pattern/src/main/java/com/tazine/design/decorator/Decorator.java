package com.tazine.design.decorator;

/**
 * 装饰器
 *
 * @author frank
 * @since 1.0.0
 */
public class Decorator extends Component {

    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
