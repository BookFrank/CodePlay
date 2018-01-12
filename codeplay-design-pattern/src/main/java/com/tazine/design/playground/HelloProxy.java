package com.tazine.design.playground;

/**
 * Created by lina on 2018/1/8.
 *
 * @author frank
 * @since 1.0.0
 */
public class HelloProxy implements Hello {

    private Hello hello;

    public HelloProxy() {
        hello = new HelloImpl();
    }

    @Override
    public void sayHello() {
        before();
        hello.sayHello();
        after();
    }

    private void before(){
        System.out.println("before()");
    }

    private void after(){
        System.out.println("after()");
    }
}
