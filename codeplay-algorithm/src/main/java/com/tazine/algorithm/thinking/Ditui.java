package com.tazine.algorithm.thinking;

/**
 * 基本算法思想之递推算法
 * 1. 根据已知结果和关系求解中间结果
 * 2. 利用推导过程来解决问题
 *
 * @author frank
 * @since 1.0.0
 */
public class Ditui {

    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    /**
     * F(n) = F(n-1) + F(n-2) 这个推导过程是递推，
     * 算法实现可以使用递归来实现这个推导过程，最终得出结果
     *
     * @param n 第n个月
     * @return 兔子数
     */
    private static int fibonacci(int n) {
        return n < 3 ? 1 : fibonacci(n - 1) + fibonacci(n - 2);
    }
}
