package com.tazine.design.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 *
 * @author frank
 * @date 2019/04/05
 */
public class FrankObserver implements Observer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        // notifyObservers(this); 把自己传递进来就是因为观察者可能同时观察好多对象

        if (o instanceof WechatObservable){
            //System.out.println(name + "收到一条微信：" + arg);
            System.out.println(name + "收到一条微信：" + ((WechatObservable)o).getMsg());
        }else if (o instanceof WeiboObservable){
            //System.out.println(name + "收到一条weibo：" + arg);
            System.out.println(name + "收到一条weibo：" + ((WeiboObservable)o).getWeibo());
        }else {
            System.err.println("error");
        }
    }
}
