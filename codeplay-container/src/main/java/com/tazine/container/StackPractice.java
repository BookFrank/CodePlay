package com.tazine.container;

import java.util.Stack;
import java.util.Vector;

/**
 * 堆栈数据结构
 *
 * @author frank
 * @since 1.0.0
 */
public class StackPractice {

    public static void main(String[] args) {
        String[] months = {"January", "Feburay", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        Stack<String> stack = new Stack<>();
        Vector<String> vector = new Vector<>();

        for (String s : months) {
            stack.push(s);
            vector.addElement(s);
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println();

        while (!vector.isEmpty()) {
            System.out.print(vector.lastElement() + " ");
            vector.remove(vector.lastElement());
        }
    }
}
