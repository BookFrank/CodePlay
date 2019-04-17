package com.tazine.design.observer.watch;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者-Rolex
 *
 * @author frank
 * @date 2017/9/9
 */
public class RolexWatch implements MyObservable {

    private List<MyObserver> myObservers = new ArrayList<>();

    @Override
    public void registerObserver(MyObserver myObserver) {
        myObservers.add(myObserver);
    }

    @Override
    public void removeObserver(MyObserver myObserver) {
        myObservers.remove(myObserver);
    }

    @Override
    public void inform(String msg) {
        for (MyObserver ob : myObservers){
            ob.update(msg);
        }
    }
}
