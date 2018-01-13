package com.tazine.design.playground;

/**
 * Created by lina on 2018/1/8.
 *
 * @author frank
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {

        // 不使用代理
        Hello hello = new HelloImpl();
        hello.sayHello();
        System.out.println();

        // 静态代理
        Hello hello1 = new HelloProxy();
        hello1.sayHello();
        System.out.println();





    }

}
