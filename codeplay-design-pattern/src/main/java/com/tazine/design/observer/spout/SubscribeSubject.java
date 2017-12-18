package com.tazine.design.observer.spout;

import com.tazine.design.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者对象：负责注册和删除观察者，并通知观察者状态变更
 * @author frank
 * @since 1.0.0
 */
public class SubscribeSubject {
    protected List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        if (observers.contains(observer)){
            observers.remove(observer);
        }
    }

    protected void notifyObservers(){
        for (Observer observer : observers){
            observer.update(this);
        }
    }
}
