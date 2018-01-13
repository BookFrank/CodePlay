package com.tazine.base.annotation.jdk;

/**
 * JDK中 @Deprecated 注解用法
 *
 * @author frank
 * @since 1.0.0
 */
public interface Player {

    String name();

    int age();

    double height();

    @Deprecated
    void care();
}
