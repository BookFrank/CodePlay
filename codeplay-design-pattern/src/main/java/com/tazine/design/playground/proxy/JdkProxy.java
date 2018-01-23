package com.tazine.design.playground.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理：只能代理具有接口的类
 *
 * @author frank
 * @since 1.0.0
 */
public class JdkProxy implements InvocationHandler {

    private Object client;

    public JdkProxy(Object client) {
        this.client = client;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(client, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("JDKProxy After()...");
    }

    private void before() {
        System.out.println("JDKProxy Before()...");
    }
}
