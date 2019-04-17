package com.tazine.design.observer.watch;

/**
 * 被观察者接口
 *
 * @author frank
 * @date 2017/9/9
 */
public interface MyObservable {

    void registerObserver(MyObserver myObserver);

    void removeObserver(MyObserver myObserver);

    void inform(String msg);
}
