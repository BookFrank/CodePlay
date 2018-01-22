package com.tazine.algorithm.playground;

/**
 * Fibonacci
 *
 * @author frank
 * @since 1.0.0
 */
public class Fibonacci {

    public static void main(String[] args) {

        for (int i = 1; i < 20; i++) {
            System.out.print(fib1(i) + " ");
        }
        System.out.println();
        for (int i = 1; i < 20; i++) {
            System.out.print(fib2(i) + " ");
        }
        System.out.println();
        for (int i = 1; i < 20; i++) {
            System.out.print(fib3(i) + " ");
        }
    }

    /**
     * 使用递归得到Fibonacci数列  指数级
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n < 0) {
            return -1;
        }
        return n < 3 ? 1 : (fib1(n - 1) + fib1(n - 2));
    }

    /**
     * 使用递推循环求解Fibonacci数列
     * 一般而言，程序中的递归都可以使用循环来代替
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n < 3) {
            return 1;
        }
        int a = 1, b = 1;
        int c = 0;
        for (int i = 1; i < n-1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 使用递推数组方式
     * @param n
     * @return
     */
    public static int fib3(int n){
        int[] arr = new int[n];
        arr[0] = 1;
        if (n > 1){
            arr[1] = 1;
        }
        for (int i = 2; i < n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n-1];
    }
}
