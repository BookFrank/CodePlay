package com.tazine.design.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 基于JDK实现的观察者
 *
 * @author frank
 * @since 1.0.0
 */
public class ConcreteObserver implements Observer {

    // 观察者名称
    private String observerName;

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(Observable o, Object arg) {
        // 推
        System.out.println(observerName + " 收到了消息 " + arg);
        // 拉
        System.out.println(observerName + " 收到了消息，主动拉消息 "
                + ((WeatherSubject) o).getWeather());
    }
}
