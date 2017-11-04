package com.tazine;

/**
 * Created by lina on 2017/10/11.
 */
public class Fibonacci {


    public int fibonacci(int n){

        if (n >= 0){
            if (n == 0 || n == 1)
                return n;
            else
                return fibonacci(n-1) + fibonacci(n-2);
        }
        return -1;
    }


    public int fac(int n){

        if (n > 0){
            return n * fac(n-1);
        }else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fac(5));
    }

}
