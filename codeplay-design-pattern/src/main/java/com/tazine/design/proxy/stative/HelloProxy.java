package com.tazine.design.proxy.stative;

import com.tazine.design.proxy.Hello;
import com.tazine.design.proxy.HelloImpl;

/**
 * 静态代理
 *
 * @author frank
 * @date 2018/02/24
 */
public class HelloProxy implements Hello {

    private Hello hello;

    public HelloProxy() {
        this.hello = new HelloImpl();
    }

    @Override
    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    @Override
    public void hi() {
        before();
        hello.hi();
        after();
    }

    private void before(){
        System.out.println("静态代理：前置通知");
    }

    private void after(){
        System.out.println("静待代理：后置通知");
    }
}
