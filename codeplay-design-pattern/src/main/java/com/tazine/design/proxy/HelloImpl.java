package com.tazine.design.proxy;

/**
 * HelloImpl
 *
 * @author frank
 * @since 1.0.0
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello " + name);
    }
}
