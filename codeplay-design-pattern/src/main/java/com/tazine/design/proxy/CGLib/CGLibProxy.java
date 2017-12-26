package com.tazine.design.proxy.CGLib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib动态代理：不用接口就能代理，方法级别的代理
 *
 * @author frank
 * @since 1.0.0
 */
public class CGLibProxy implements MethodInterceptor {

    private static CGLibProxy instance = new CGLibProxy();

    private CGLibProxy() {
    }

    public static CGLibProxy getInstance(){
        return instance;
    }

    @SuppressWarnings(value = "unchecked")
    public <T> T getProxy(Class<T> t) {
        return (T) Enhancer.create(t, this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        methodProxy.invokeSuper(o, objects);
        after();
        return null;
    }

    private void before() {
        System.out.println("CGLib 动态代理模式：say() 方法之前逻辑");
    }

    private void after() {
        System.out.println("CGLib 动态代理模式：say() 方法之后逻辑");
    }
}
