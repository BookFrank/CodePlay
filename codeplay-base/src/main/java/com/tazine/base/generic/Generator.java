package com.tazine.base.generic;

/**
 * 泛型接口，常用于生产器
 *
 * @author Frank
 * @since 1.0.0
 */
public interface Generator<T> {

    T make();

}
