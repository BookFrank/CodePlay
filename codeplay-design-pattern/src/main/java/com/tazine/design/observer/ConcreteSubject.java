package com.tazine.design.observer;

/**
 * 具体的观察者对象
 *
 * @author frank
 * @since 1.0.0
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
