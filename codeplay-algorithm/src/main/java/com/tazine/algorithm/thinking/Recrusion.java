package com.tazine.algorithm.thinking;

/**
 * 基本算法思想之递归算法
 *
 * @author frank
 * @since 1.0.0
 */
public class Recrusion {

    public static void main(String[] args) {
        for (int i =1;i <6; i++){
            System.out.println(fact(i));
        }
    }

    /**
     * 求阶乘
     * @param n 阶乘数
     * @return result
     */
    private static int fact(int n){
        return n < 2 ? 1 : n * fact(n-1);
    }

}
