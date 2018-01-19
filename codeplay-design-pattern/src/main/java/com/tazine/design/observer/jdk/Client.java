package com.tazine.design.observer.jdk;

import com.tazine.design.observer.ConcreteSubject;

import java.util.Observer;

/**
 * Test
 *
 * @author frank
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args) {

        WeatherSubject subject = new WeatherSubject();
        ConcreteObserver observer = new ConcreteObserver();
        observer.setObserverName("frank");
        subject.addObserver(observer);

        subject.setWeather("rainy");
    }
}
