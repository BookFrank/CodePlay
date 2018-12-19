package com.tazine.container;

import java.util.Stack;

/**
 * 利用stack来反转字符串
 *
 * @author frank
 * @date 2018/1/11
 */
public class StringReverse {

    public static void main(String[] args) {

        String s = "Hello World";
        Stack<Character> stack = new Stack();
        for (Character c : s.toCharArray()){
            stack.push(c);
        }
        while (!stack.empty()){
            System.out.print(stack.pop() + " ");
        }



    }

}
