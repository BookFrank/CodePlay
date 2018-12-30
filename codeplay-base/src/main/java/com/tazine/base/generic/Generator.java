package com.tazine.base.generic;

/**
 * 泛型接口，常用于生产器
 *
 * @author Frank
 * @date 2017/12/27
 */
public interface Generator<T> {

    T make();

}
