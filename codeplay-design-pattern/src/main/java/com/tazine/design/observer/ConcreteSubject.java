package com.tazine.design.observer;

/**
 * 具体的观察者对象
 *
 * @author frank
 * @date 2017/9/10
 */
public class ConcreteSubject extends Subject {

    private String monitorState;

    public String getMonitorState() {
        return monitorState;
    }

    public void setMonitorState(String monitorState) {
        this.monitorState = monitorState;
        this.informAll();
    }
}
