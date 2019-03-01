package com.tazine.base.object.func;

/**
 * ClassDemo
 *
 * @author frank
 * @date 2018/03/01
 */
public class ClassDemo {

    /**
     * 在类初次被加载到内存中执行
     */
    static {
        System.out.println("------执行静态代码块------");
    }

    /**
     * 构造函数
     *
     * @explain 在类每次被加载到内存中执行（创建对象时）
     */
    public ClassDemo() {
        System.out.println("------调用构造函数------");
    }

    /**
     * 非静态代码块
     * @explain 在类每次被实例化时执行
     */
    {
        System.out.println("------执行非静态代码块------");
    }
}
