package com.tazine.design.proxy;

import com.tazine.design.proxy.CGLib.CGLibProxy;
import com.tazine.design.proxy.dynamic.DynamicProxy;
import com.tazine.design.proxy.dynamic.SimpDynamicProxy;
import com.tazine.design.proxy.stative.HelloProxy;

import java.lang.reflect.Proxy;

/**
 * 代理测试类
 *
 * @author frank
 * @since 1.0.0
 */
public class ProxyTest {

    public static void main(String[] args) {

        // 正常业务逻辑
        Hello hello = new HelloImpl();
        hello.say("Frank");
        hello.hi();
        System.out.println();

        // 现在想在say()前后加上一些处理逻辑

        // 使用静态代理
        Hello staticProxy = new HelloProxy();
        staticProxy.say("Static Proxy");
        // 使用静态代理，接口每增加一个方法，相应的代理类也要修改
        staticProxy.hi();
        System.out.println();

        // 使用简单动态代理
        SimpDynamicProxy simpDynamicProxy = new SimpDynamicProxy(hello);
        Hello simpProxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), simpDynamicProxy);
        simpProxy.say("SimpleDynamicProxy");
        simpProxy.hi();
        System.out.println();

        // 使用高级动态代理
        DynamicProxy dynamicProxy = new DynamicProxy(hello);
        Hello helloProxy = dynamicProxy.getProxy(Hello.class);
        helloProxy.say("DynamicProxy");
        System.out.println();

        // CGLib 动态代理：方法级别的代理
        Hello cgProxy = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        cgProxy.say("Frank");
    }
}
