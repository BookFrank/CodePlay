package com.tazine.design.decorator;

/**
 * 构件实例
 *
 * @author frank
 * @since 1.0.0
 */
public class ConcreteComponent extends Component {

    @Override
    public void operation() {
        System.out.println("这是我原本就有的功能");
    }
}
