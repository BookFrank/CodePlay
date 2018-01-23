package com.tazine.algorithm.thinking;

/**
 * 基本算法思想之概率算法
 *
 * @author frank
 * @since 1.0.0
 */
public class Probability {

    public static void main(String[] args) {
        int n = 10000000;
        monteCarlo(n);
    }

    /**
     * 蒙特卡洛算法计算圆周率
     * 1. 均匀撒点
     * 2. 区域判断
     *
     * @param n 撒点数
     */
    private static void monteCarlo(int n) {
        int count = 0;
        double x, y;
        for (int i = 0; i < n; i++) {
            x = Math.random();
            y = Math.random();
            if (x * x + y * y <= 1) {
                count++;
            }
        }
        System.out.println((count / (n * 1.00)) * 4);
    }
}
