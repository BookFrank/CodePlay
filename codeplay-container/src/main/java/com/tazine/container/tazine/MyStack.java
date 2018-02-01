package com.tazine.container.tazine;

import java.util.Arrays;

/**
 * MyStack
 *
 * @author frank
 * @since 1.0.0
 */
public class MyStack<E> {

    private Object[] stack;

    private static final int INIT_CAPACITY = 10;

    /**
     * 当前数组元素个数
     */
    private int size;

    public MyStack() {
        this(INIT_CAPACITY);
    }

    public MyStack(int len) {
        stack = new Object[len];
    }

    public boolean offer(E element) {
        ensureCapacity(size + 1);
        stack[size++] = element;
        return true;
    }

    public E peek() {
        if (size > 0) {
            System.out.println(stack[size - 1]);
            return (E) stack[size - 1];
        }
        return null;
    }

    public E pop() {
        E e = peek();
        stack[--size] = null;
        return e;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity >= stack.length) {
            grow();
        }
    }

    private void grow() {
        int oldCapacity = stack.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        stack = Arrays.copyOf(stack, newCapacity);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        MyStack<String> stack = new MyStack<>();
        stack.offer("kobe");
        stack.offer("james");

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        /**
         * 如何使用 O(1) 的时间复杂度求栈中最小元素
         */

    }
}
