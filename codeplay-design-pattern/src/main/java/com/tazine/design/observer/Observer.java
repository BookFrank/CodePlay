package com.tazine.design.observer;

/**
 * 观察者接口：提供一个更新接口给那些有消息来时要通知的对象
 *
 * @author frank
 * @since 1.0.0
 */
public interface Observer {

    void update(Subject subject);
}
