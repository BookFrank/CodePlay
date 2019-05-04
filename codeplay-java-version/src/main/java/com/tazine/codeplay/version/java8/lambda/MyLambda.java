package com.tazine.codeplay.version.java8.lambda;

/**
 * 自定义 lambda 接口
 *
 * @author frank
 * @date 2019/05/04
 */
@FunctionalInterface
public interface MyLambda<T> {

    void desc(T t);

}
