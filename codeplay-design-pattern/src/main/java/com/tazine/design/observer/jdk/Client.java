package com.tazine.design.observer.jdk;

import com.tazine.design.observer.jdk.weather.WeatherObservable;
import com.tazine.design.observer.jdk.weather.WeatherObserver;

/**
 * Test
 *
 * @author frank
 * @date 2017/9/9
 */
public class Client {

    public static void main(String[] args) {

        // 创建观察者和被观察者
        WeatherObservable subject = new WeatherObservable();
        WeatherObserver observer1 = new WeatherObserver();
        observer1.setObserverName("北京交通广播电台");
        WeatherObserver observer2 = new WeatherObserver();
        observer2.setObserverName("上海人民广播电台");

        // 配置观察者开始观测被观察对象
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // 被观察对象开始状态改变
        subject.setWeather("rainy");
        System.out.println();
        subject.setWeather("cloudy");
        System.out.println();

        WechatObservable wechat = new WechatObservable();
        WeiboObservable weibo = new WeiboObservable();
        FrankObserver frank = new FrankObserver();
        frank.setName("frank");

        wechat.addObserver(frank);
        weibo.addObserver(frank);

        wechat.recv("Elon: Hello");
        weibo.newWeibo("Jackson: Made it");
    }
}
