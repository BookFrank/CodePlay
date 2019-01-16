package com.tazine.design.flyweight;

/**
 * 享元模式-享元模式（Flyweight Pattern）主要用于减少创建对象的数量，
 * 以减少内存占用和提高性能。这种类型的设计模式属于结构型模式，它提供了减少对象数量从而改善应用所需的对象结构的方式。
 * <p>
 * 享元模式尝试重用现有的同类对象，如果未找到匹配的对象，则创建新对象。
 * 我们将通过创建 5 个对象来画出 20 个分布于不同位置的圆来演示这种模式
 *
 * @author frank
 * @date 2019/1/13
 */
public interface Shape {

    void draw();

}
