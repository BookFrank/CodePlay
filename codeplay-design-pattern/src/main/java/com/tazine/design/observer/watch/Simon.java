package com.tazine.design.observer.watch;

/**
 * 观察者-Simon
 *
 * @author frank
 * @date 2017/9/9
 */
public class Simon implements MyObserver,Display{

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
