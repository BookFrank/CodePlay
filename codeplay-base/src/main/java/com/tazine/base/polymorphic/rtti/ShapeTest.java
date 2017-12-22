package com.tazine.base.polymorphic.rtti;

/**
 * RTTI
 *
 * @author frank
 * @since 1.0.0
 */
public class ShapeTest {

    public static void main(String[] args) {

        Shape[] shapes = {new Circle(), new Triangle(), new Square()};

        for (Shape shape : shapes) {
            shape.draw();
            System.out.println(shape.getClass().getSimpleName());
        }

    }

    /*
        当把 Circle 对象放入 Shape[] 会向上转型，在向上转型为 Shape 的过程中会丢失 Circle 对象的具体类型，
        对于数组而言，它们只是 Shape 类的对象

        当从数组中取出元素时，这种容器（实际上将所有对象都当做Object类型）会将结果转型回 Shape，这是RTTI的基本使用形式。
        在Java中，所有的类型转换都是在运行时进行正确性检查的，RTTI名字的含义，就是运行时，识别一个对象的类型;

        在上面的例子中。Object取出来后转为Shape类型，而不是转为Circle等，因为在编译时，只知道数组是Shape类型的。
        但是在执行时，RTTI 就可以根据Class对象，将Shape对象转为正确的 Circle、Triangle等，使得数组中取出来的
        shape 引用指向被正确转换的Circle对象的实例。
     */
}
