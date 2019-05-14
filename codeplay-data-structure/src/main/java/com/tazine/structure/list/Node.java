package com.tazine.structure.list;

/**
 * Node in the list
 *
 * @author frank
 * @date 2017/12/22
 */
public class Node<T> {

    Node<T> next = null;

    T data;

    public Node(T data) {
        this.data = data;
    }
}
