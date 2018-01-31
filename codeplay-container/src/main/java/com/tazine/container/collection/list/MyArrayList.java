package com.tazine.container.collection.list;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * MyArrayList
 *
 * @author frank
 * @since 1.0.0
 */
public class MyArrayList<E> implements Iterable<E> {

    private static final int INIT_CAPACITY = 10;

    private static Object[] list;

    private static int size;

    public MyArrayList() {
        this(INIT_CAPACITY);
    }

    public MyArrayList(int initCapacity) {
        list = new Object[initCapacity];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E element){
        ensureCapacity(size + 1);
        list[size++] = element;
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = list.length;
        if (oldCapacity < minCapacity){
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            System.out.println("扩容至 " + newCapacity);
            list = Arrays.copyOf(list, newCapacity);
        }
    }

    public E get(int i){
        rangeCheck(i);
        return (E) list[i];
    }

    private void rangeCheck(int i) {
        if (i >= size){
            throw new IndexOutOfBoundsException("out of bounds");
        }
    }

    public boolean contains(E element){
        int i = indexOf(element);
        return true;
    }

    private int indexOf(E element) {
        if (element == null){
        }
        return -1;
    }

    public E remove(int i){
        rangeCheck(i);
        E data = (E) list[i];
        int numsMoved = size - 1 -i;
        if (numsMoved > 0){
            System.arraycopy(list,i+1,list,i,numsMoved);
        }
        return data;
    }

    public static void main(String[] args) {

        MyArrayList<String> list = new MyArrayList<>();

        list.add("kobe");
        list.add("james");
        list.add("iverson");

        System.out.println(list.get(0));
        System.out.println(list.get(1));

        list.remove(0);
        System.out.println(list.get(0));
        System.out.println(list.get(1));

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
