package com.tazine.base.polymorphic.rtti;

/**
 * RTTI
 *
 * @author frank
 * @since 1.0.0
 */
public abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    @Override
    public abstract String toString();
}

class Circle extends Shape {

    @Override
    public String toString() {
        return "circle";
    }
}

class Triangle extends Shape {

    @Override
    public String toString() {
        return "triangle";
    }
}

class Square extends Shape {

    @Override
    public String toString() {
        return "square";
    }
}
