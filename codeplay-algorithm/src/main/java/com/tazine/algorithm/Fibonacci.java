package com.tazine.algorithm;

/**
 * 斐波那契数列
 *
 * @author Frank
 * @since 1.0.0
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fac(5));
    }

    public int fibonacci(int n) {

        if (n >= 0) {
            if (n == 0 || n == 1)
                return n;
            else
                return fibonacci(n - 1) + fibonacci(n - 2);
        }
        return -1;
    }

    public int fac(int n) {

        if (n > 0) {
            return n * fac(n - 1);
        } else {
            return 1;
        }
    }
}
