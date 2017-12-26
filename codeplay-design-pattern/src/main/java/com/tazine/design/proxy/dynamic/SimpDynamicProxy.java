package com.tazine.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 简单动态代理
 *
 * @author frank
 * @since 1.0.0
 */
public class SimpDynamicProxy implements InvocationHandler {

    private Object client;

    public SimpDynamicProxy(Object client) {
        this.client = client;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = null;
        result = method.invoke(client, args);
        after();
        return result;
    }

    private void before(){
        System.out.println("简单动态代理模式：say() 方法之前逻辑");
    }

    private void after(){
        System.out.println("简单动态代理模式：say() 方法之后逻辑");
    }
}
