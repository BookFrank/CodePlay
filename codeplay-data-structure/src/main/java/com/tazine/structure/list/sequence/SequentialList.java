package com.tazine.structure.list.sequence;

/**
 * SequentialList 顺序表
 *
 * @author frank
 * @since 1.0.0
 */
public class SequentialList<T> {

    // 线性表当前已保存的数量
    private int index;

    // 线性表长度
    private int length;

    private T[] list;

    public SequentialList(int length) {
        this.length = length;
        list = (T[]) new Object[length];
    }

    public int getLength() {
        return length;
    }

    public int add(T t) {
        if (index < length) {
            list[index++] = t;
            return index;
        }
        return 0;
    }

    public int insert(int n, T data) {
        if (n > length - 1 || n <= 0) {
            return 0;
        } else {
            int i = index;
            while (i > n){
                list[i] = list[i -1];
                i--;
            }
            list[n] = data;
            return n;
        }
    }


    public void print() {
        for (int i = 0; i < index; i++) {
            System.out.print(list[i] + ", ");
        }
    }


}
