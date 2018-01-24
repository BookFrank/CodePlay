package com.tazine.algorithm.sort;

import java.util.Arrays;

/**
 * QuickSort
 *
 * @author frank
 * @since 1.0.0
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {5, 1, 4, 3, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序 NlogN
     *
     * @param arr   待排序数组
     * @param left  数组左下标
     * @param right 数组右下标
     */
    private static void quickSort(int[] arr, int left, int right) {
        int i, j, tmp, base;
        i = left;
        j = right;
        if (left >= right){
            return;
        }
        base = arr[left];
        while (i != j) {
            while ((i < j) && (arr[j] >= base)) {
                j--;
            }
            while ((i < j) && (arr[i] <= base)) {
                i++;
            }
            if (i < j) {
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        arr[left] = arr[i];
        arr[i] = base;
        System.out.println(left + " -- " + (i-1) + " | " + (i+1) + " -- " + right);
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }
}
