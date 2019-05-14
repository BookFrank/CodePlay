package com.tazine.design.observer;

/**
 * 具体观察者对象：实现更新的方法，使订阅目标与自身状态保持一致
 *
 * @author frank
 * @date 2017/9/10
 */
public class ConcreteObserver implements Observer {

    private String monitorState;

    @Override
    public void update(Subject subject) {
        ConcreteSubject s = (ConcreteSubject) subject;
        monitorState = s.getMonitorState();
        display();
    }

    private void display() {
        System.out.println("收到消息：" + monitorState);
    }
}
