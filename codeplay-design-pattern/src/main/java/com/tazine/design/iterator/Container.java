package com.tazine.design.iterator;

/**
 * 通过 Container 持有 Iterator
 *
 * @author frank
 * @since 1.0.0
 */
public interface Container {

    public Iterator getIterator();

}
