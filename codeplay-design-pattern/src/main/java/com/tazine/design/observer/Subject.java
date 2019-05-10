package com.tazine.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者父类
 *
 * @author frank
 * @date 2017/9/10
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void register(Observer observer){
        observers.add(observer);
    }

    public void unsubscribe(Observer observer){
        observers.remove(observer);
    }

    public void informAll(){
        for (Observer ob : observers){
            ob.update(this);
        }
    }
}
