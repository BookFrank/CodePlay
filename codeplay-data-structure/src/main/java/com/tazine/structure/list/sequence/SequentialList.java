package com.tazine.structure.list.sequence;

/**
 * Created by lina on 2018/1/19.
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

    public int add(T t){
        if (index < length){
            list[index++] = t;
            return index;
        }
        return 0;
    }

    public int insert(int n , T data){
        if (n > length || n <= 0){
            return 0;
        }else {
            return 1;
        }
    }

    public void print(){
        for (int i = 0; i<index; i++){
            System.out.print(list[i] + " ");
        }
    }


}
