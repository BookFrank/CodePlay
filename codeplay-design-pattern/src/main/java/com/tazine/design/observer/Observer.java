package com.tazine.design.observer;

import com.tazine.design.observer.target.TargetSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者接口：提供一个更新接口给那些有消息来时要通知的对象
 *
 * @author frank
 * @since 1.0.0
 */
public interface Observer {

    void update(TargetSubject info);
}
