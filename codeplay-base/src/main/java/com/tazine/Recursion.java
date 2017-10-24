package com.tazine;

/**
 * Created by ly on 2017/10/11.
 * 存在直接或间接调用自身的算法成为递归算法
 */
public class Recursion {

    /**
     * 斐波那契数列
     * f(n) = {
     *     n , n = 0,1
     *     f(n-2)+f(n-1), n>=2
     * }
     * @param n
     * @return
     */
    public int fibonacci(int n){

        if (n >= 0){
            if (n==0 || n==1)
                return n;
            else
                return fibonacci(n-2) + fibonacci(n-1);
        }
        return -1;
    }


    /**
     * 阶乘算法
     * f(n)={
     *     1, n = 0,1
     *     n!, n>=2
     * }
     * @param n
     * @return
     */
    public int factorial(int n){

        if (n >= 0){
            if (n==0 || n==1)
                return 1;
            else
                return n * factorial(n-1);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Recursion().fibonacci(10));
        System.out.println(new Recursion().factorial(5));
    }



}
