package com.tazine.container.collection.queue;

import java.util.Stack;

/**
 * 使用两个 Stack 实现队列功能
 *
 * @author frank
 * @since 1.0.0
 */
public class MyQueue<E> {

    private Stack<E> inStack = new Stack<>();

    private Stack<E> popStack = new Stack<>();

    public MyQueue() {
    }

    public synchronized E push(E data) {
        return inStack.push(data);
    }

    public synchronized E pop() {
        if (popStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                popStack.push(inStack.pop());
            }
        }
        return popStack.pop();
    }

    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        queue.push("01");
        queue.push("02");
        queue.push("03");
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
