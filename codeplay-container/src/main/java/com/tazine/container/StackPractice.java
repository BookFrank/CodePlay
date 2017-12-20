package com.tazine.container;

import java.util.Stack;

/**
 * Created by lina on 2017/12/20.
 */
public class StackPractice {

    public static void main(String[] args) {

        String[] months = {"January", "Feburay","March","April","May","June","July","August","September","October","November","December"};

        Stack<String> stack = new Stack<>();

        for (String s : months){
            stack.push(s);
        }

        while (!stack.empty()){
            System.out.println(stack.pop());
        }

    }

}
