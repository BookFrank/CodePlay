package com.tazine.container.collection.list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * MyArrayList
 *
 * @author frank
 * @since 1.0.0
 */
public class MyArrayList<T> implements Iterable<T> {

    private static int INIT_SIZE = 16;

    private static Object[] arr;

    /**
     * 数组当前下标
     */
    private int index;

    /**
     * 数组当前长度
     */
    private int size;

    public int size() {
        return index;
    }

    public MyArrayList(int size) {
        this.size = size;
        arr = new Object[size];
    }

    public MyArrayList() {
        this(INIT_SIZE);
    }

    public int add(T obj) {
        expand(index);
        arr[index++] = obj;
        return index;
    }

    public T get(int i) {
        if (i <= index) {
            return (T) arr[i];
        } else {
            return null;
        }
    }

    public void remove(int i) {
        if (i < index) {
            for (int j = i; j < index; j++) {
                arr[j] = arr[j + 1];
            }
            index--;
        } else if (i == index) {
            arr[index--] = null;
        }
    }

    private synchronized void expand(int index) {
        // 可以在这里调整
        if (index == size) {
            Object[] newArr = new Object[size * 2];
            for (int i = 0; i < index; i++) {
                newArr[i] = arr[i];
            }
            System.out.println("完成扩容");
            arr = newArr;
            size = size * 2;
        }
    }

    public class ListIterator<T> implements java.util.Iterator<T> {

        int start = 0;

        @Override
        public boolean hasNext() {
            if (start < index) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return (T) arr[start++];
            }
            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>();
    }

    public static void main(String[] args) {

        MyArrayList<String> list = new MyArrayList<>();

        list.add("kobe");
        list.add("james");
        list.add("iverson");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.size());

        list.remove(0);

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
