package com.tazine.design.observer.watch;


/**
 * 观察者-Frank
 *
 * @author frank
 * @since 1.0.0
 */
public class Frank implements Observer, Display {

    private String time;

    @Override
    public void update(String timestamp) {
        this.time = timestamp;
        display();
    }

    @Override
    public void display() {
        System.out.println("Frank收到消息：" + time);
    }
}
