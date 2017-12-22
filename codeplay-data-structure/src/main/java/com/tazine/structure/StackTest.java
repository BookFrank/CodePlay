package com.tazine.structure;

import com.tazine.structure.stack.MyArrayStack;

/**
 * Stack Test
 *
 * @author frank
 * @since 1.0.0
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
