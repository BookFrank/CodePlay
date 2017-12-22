package com.tazine.structure.list;

/**
 * Node in the list
 *
 * @author frank
 * @since 1.0.0
 */
public class Node<T> {

    Node<T> next = null;

    T data;

    public Node(T data) {
        this.data = data;
    }
}
