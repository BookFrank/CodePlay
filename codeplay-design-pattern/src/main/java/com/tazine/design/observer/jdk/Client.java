package com.tazine.design.observer.jdk;

/**
 * Test
 *
 * @author frank
 * @date 2017/9/9
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
