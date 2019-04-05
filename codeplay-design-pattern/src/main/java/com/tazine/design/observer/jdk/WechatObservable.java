package com.tazine.design.observer.jdk;

import java.util.Observable;

/**
 * 被观察者-微信
 *
 * @author frank
 * @date 2019/04/05
 */
public class WechatObservable extends Observable {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void recv(String msg) {
        this.msg = msg;

        setChanged();

        notifyObservers();
        //notifyObservers(this);
        //notifyObservers(msg);
    }
}
