package com.tazine.base.annotation.jdk;

/**
 * JDK中 @Deprecated 注解用法
 *
 * @author frank
 * @date 2017/12/15
 */
public interface Player {

    String name();

    int age();

    double height();

    @Deprecated
    void care();
}
