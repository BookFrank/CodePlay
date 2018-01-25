package com.tazine.algorithm.sort.inner;

import java.util.Arrays;

/**
 * ShellSort 缩小增量排序
 *
 * @author frank
 * @since 1.0.0
 */
public class ShellSort {


    public static void main(String[] args) {
        int[] arr = {127, 118, 105, 101, 112, 107, 112, 120};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
    }

    /**
     * 三种嵌套循环。
     * 最外层的循环，用来分解数组元素为多个序列，每次比较晾数的间距，直到其值为 0 就结束循环
     * 中间层循环按设置的间距 r，分别比较对应序列的数组元素
     * 最内层循环中使用插入排序法对指定间距的元素进行排序。
     *
     * @param arr 待排序数组
     */
    private static void shellSort(int[] arr) {

        int tmp, j;
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                tmp = arr[i];
                // 算法核心，通过 i-gap，取得其对应序列中的另一元素
                j = i - gap;
                while ((j >= 0) && (arr[j] > tmp)) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            System.out.println(Arrays.toString(arr));
        }

    }
}
