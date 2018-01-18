package com.tazine.design.observer;

/**
 * Observer Design Pattern Test
 *
 * @author frank
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {

        ConcreteSubject subject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        subject.register(observer);

        subject.setMonitorState("snow");
    }
}
