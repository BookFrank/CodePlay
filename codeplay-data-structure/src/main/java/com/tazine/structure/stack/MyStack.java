package com.tazine.structure.stack;

import com.tazine.structure.list.MyLinkedList;

/**
 * MyStack
 *
 * @author frank
 * @date 2017/12/22
 */
public class MyStack<T> {

    private MyLinkedList<T> stack = new MyLinkedList<>();

    public void push(T i) {
        stack.add(i);
    }

    public boolean empty() {
        return null == stack;
    }

    public T pop() {
        T data = stack.get(stack.size()-1);
        stack.remove(data);
        return data;
    }
}
