package com.tazine.container.tazine;

/**
 * 如何用 O(1) 的时间复杂度求栈中最小元素 ？
 *
 * @author frank
 * @since 1.0.0
 */
public class MyStack1 {

    /**
     * 真实元素栈
     */
    private MyStack<Integer> stack1 = new MyStack<>();

    /**
     * 最小值栈
     */
    private MyStack<Integer> stack2 = new MyStack<>();

    public boolean push(Integer i){
        if (stack1.isEmpty()){
            stack1.offer(i);
            stack2.offer(i);
        }else {
            if (i <= stack2.peek()){
                stack2.offer(i);
            }
        }
        return true;
    }

    public Integer pop(){
        int e = stack1.pop();
        System.out.println(e + "---" + stack2.peek());
        if (e == stack2.peek()){
            stack2.pop();
        }

        return e;
    }

    public Integer min(){
        return stack2.peek();
    }

    public static void main(String[] args) {

        MyStack1 stack1 = new MyStack1();

        stack1.push(5);
//        System.out.println(stack1.min());
        stack1.push(2);
//        System.out.println(stack1.min());
        stack1.push(3);
//        System.out.println(stack1.min());
        stack1.push(1);
//        System.out.println(stack1.min());

        System.out.println();
        System.out.println();
        stack1.pop();
//        System.out.println(stack1.min());


    }
}
