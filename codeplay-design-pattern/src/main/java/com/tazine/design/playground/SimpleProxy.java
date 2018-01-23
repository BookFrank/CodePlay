package com.tazine.design.playground;

/**
 * 代理角色：通过持有真实对象完成代理
 *
 * @author frank
 * @since 1.0.0
 */
public class SimpleProxy implements Hello {

    // 需要代理的对象
    private Hello client;

    public SimpleProxy(Hello client) {
        this.client = client;
    }

    @Override
    public void sayHello() {
        before();
        client.sayHello();
        after();
    }

    private void after() {
        System.out.println("After...");
    }

    private void before() {
        System.out.println("Before...");
    }
}
