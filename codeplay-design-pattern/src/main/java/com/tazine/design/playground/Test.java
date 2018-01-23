package com.tazine.design.playground;

import com.tazine.design.playground.proxy.JdkProxy;

import java.lang.reflect.Proxy;

/**
 * ProxyTest
 *
 * @author frank
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {

        // 简单代理：通过持有真实对象完成代理
        Hello hello = new HelloImpl();
        Hello proxy = new SimpleProxy(hello);

        hello.sayHello();
        System.out.println();
        proxy.sayHello();
        System.out.println();

        // JDK 动态代理：实现InvocationHandler接口并通过 Proxy.newProxyInstance()动态生成对象
        JdkProxy handler = new JdkProxy(hello);
        Hello proxy1 = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        proxy1.sayHello();
    }
}
