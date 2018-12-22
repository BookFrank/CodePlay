package com.tazine.structure.stack;

/**
 * Created by lina on 2017/12/22.
 *
 * @author frank
 * @date 2017/12/22
 */
public class MyArrayStack<T> {

    private T[] stack = (T[]) new Object[16];

    private int size;


    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    public void push(T a) {
        if (stack.length == 0) {
            stack[0] = a;
            size = 1;
        }else if (size < stack.length){
            stack[size + 1] = a;
            size++;
        }
    }

    public T pop(){
        T a = stack[0];
        for (int i=0;i<stack.length - 1;i++){
            stack[i] = stack[i+1];
            stack[i+1] = null;
        }
        size--;
        return a;
    }
}
