package com.tazine.design.factory.abstraction;

import com.tazine.design.factory.abstraction.product.Color;
import com.tazine.design.factory.abstraction.product.Shape;

/**
 * 抽象工厂：主要解决接口选择问题,在一个工厂里聚合多个同类产品。
 *
 * @author frank
 * @since 1.0.0
 */
public abstract class AbstractFactory {

    abstract Color getColor(String name);

    abstract Shape getShape(String shape);
}
