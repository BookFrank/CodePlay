package com.tazine.structure.stack;

/**
 * Stack Test
 *
 * @author frank
 * @date 2017/12/22
 */
public class StackTest {


    public static void main(String[] args) {


        //MyStack<Integer> stack = new MyStack<>();

        MyArrayStack<Integer> stack = new MyArrayStack<>();

        Integer a = new Integer(1);
        Integer b = new Integer(2);
        Integer c = new Integer(3);

        stack.push(a);
        stack.push(b);
        stack.push(c);

//        System.out.println(stack.empty());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
