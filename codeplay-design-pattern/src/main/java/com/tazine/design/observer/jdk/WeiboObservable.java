package com.tazine.design.observer.jdk;

import java.util.Observable;

/**
 * 被观察者-微博
 *
 * @author frank
 * @date 2019/04/05
 */
public class WeiboObservable extends Observable{

    private String weibo;

    public String getWeibo() {
        return weibo;
    }

    public void newWeibo(String wb){
        this.weibo = wb;

        setChanged();

        // 拉模式
        notifyObservers();
        //notifyObservers(this);

        // 推模式
        //notifyObservers(weibo);
    }
}
