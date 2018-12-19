package com.tazine.container.tazine;

import java.util.Arrays;

/**
 * 基于数组实现 ArrayList
 *
 * @author frank
 * @date 2018/1/11
 */
public class MyArrayList<E> {

    private static final int INIT_CAPACITY = 2;

    private Object[] arr;

    /**
     * 数组当前位置
     */
    private int size;

    public MyArrayList() {
        this(INIT_CAPACITY);
    }

    public MyArrayList(int len) {
        arr = new Object[len];
    }

    public int size() {
        return size;
    }

    public E get(int i) {
        if (i <= size) {
            return (E) arr[i];
        }
        return null;
    }

    public boolean remove(int i) {
        if (i <= size && i >= 0) {
            for (int j = i; j < size; j++) {
                arr[j] = arr[j + 1];
            }
            size--;
            return true;
        }
        return false;
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public boolean add(E element) {
        ensureCapacity(size + 1);
        arr[size++] = element;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity >= arr.length) {
            grow();
        }
    }

    private void grow() {
        int oldCapacity = arr.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        arr = Arrays.copyOf(arr, newCapacity);
        //System.out.println("容量从" + oldCapacity + " 增加至" + newCapacity);
        //list();
    }

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("kobe");
        list.add("james");
        list.add("iverson");
        list.list();
        list.remove(0);
        list.list();
    }
}
