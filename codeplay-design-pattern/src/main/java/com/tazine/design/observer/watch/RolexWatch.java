package com.tazine.design.observer.watch;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者-Rolex
 *
 * @author frank
 * @since 1.0.0
 */
public class RolexWatch implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void inform(String msg) {
        for (Observer ob : observers){
            ob.update(msg);
        }
    }
}
