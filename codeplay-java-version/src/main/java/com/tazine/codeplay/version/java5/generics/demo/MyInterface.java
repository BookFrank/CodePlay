package com.tazine.codeplay.version.java5.generics.demo;

/**
 * 泛型接口
 *
 * @author frank
 * @date 2019/06/10
 */
public interface MyInterface<T, V> {

    void onSuccess(T t, V v);
}
