package com.tazine.design.proxy;

/**
 * HelloImpl
 *
 * @author frank
 * @date 2018/02/24
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello " + name);
    }

    @Override
    public void hi() {
        System.out.println("Hello World.");
    }
}
