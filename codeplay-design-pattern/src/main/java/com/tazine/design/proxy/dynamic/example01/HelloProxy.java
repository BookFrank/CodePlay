package com.tazine.design.proxy.dynamic.example01;

/**
 * Proxy
 *
 * @author frank
 * @since 1.0.0
 */
public class HelloProxy implements Hello {

    /*
       场景：如果要在 println() 前面和后面需要处理一些逻辑，怎么做？
       把逻辑写死在 HelloImpl.say() ？ 不，这样不够优雅。

       可以使用代理模式，写一个 HelloProxy 类，让它去掉用 HelloImpl.say()，
       在调用前后分别进行逻辑处理就可以了。
     */

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

    private void before() {
        System.out.println("云想衣裳，");
    }

    private void after() {
        System.out.println("花想容。");
    }

    public static void main(String[] args) {

        Hello hello = new HelloImpl();
        hello.say("Frank");

        Hello proxy = new HelloProxy();
        proxy.say("Kobe");
    }
}
