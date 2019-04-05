package com.tazine.design.observer.watch;

/**
 * 被观察者接口
 *
 * @author frank
 * @since 1.0.0
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void inform(String msg);
}
