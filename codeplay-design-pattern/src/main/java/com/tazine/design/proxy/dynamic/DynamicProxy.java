package com.tazine.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * DynamicProxy
 *
 * @author frank
 * @since 1.0.0
 */
public class DynamicProxy implements InvocationHandler{

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @SuppressWarnings(value = "unchecked")
    public <T> T getProxy(Class<T> t){
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target,args);
        after();
        return result;
    }

    private void before(){
        System.out.println("高级动态代理模式：say() 方法之前逻辑");
    }

    private void after(){
        System.out.println("高级动态代理模式：say() 方法之后逻辑");
    }
}
