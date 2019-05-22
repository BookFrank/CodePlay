package com.tazine.design.observer.jdk.weather;

import java.util.Observable;

/**
 * 基于JDK实现的被观察者
 *
 * @author frank
 * @date 2017/9/9
 */
public class WeatherObservable extends Observable {

    private String weather;

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;

        // 当天气改变时，通知所有的观察者
        // 在通知之前，必须调用 setChanged()
        this.setChanged();

        // 然后主动通知，拉模式，当使用拉模式时，观察者也需要采用拉模式获取数据
        this.notifyObservers();

        // 推模式
        //this.notifyObservers(weather);
    }
}
