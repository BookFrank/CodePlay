package com.tazine.design.observer.watch;

/**
 * 观察者-Simon
 *
 * @author frank
 * @since 1.0.0
 */
public class Simon implements Observer ,Display{

    private String time;

    @Override
    public void update(String timestamp) {
        this.time = timestamp;
        display();
    }

    @Override
    public void display() {
        System.out.println("Simon收到消息：" + time);
    }
}
