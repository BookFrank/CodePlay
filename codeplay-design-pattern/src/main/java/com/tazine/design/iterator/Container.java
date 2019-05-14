package com.tazine.design.iterator;

/**
 * 通过 Container 持有 Iterator
 *
 * @author frank
 * @date 2018/01/19
 */
public interface Container {

    public Iterator getIterator();

}
