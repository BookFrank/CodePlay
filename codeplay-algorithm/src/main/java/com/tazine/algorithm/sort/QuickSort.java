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

        //Arrays.sort(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        int f = arr[(left + right) / 2];//被选中的临界值
        int ltemp = left;
        int rtemp = right;

        while (ltemp < rtemp) {
            while (arr[ltemp] < f) {
                ++ltemp;
            }
            while (arr[rtemp] > f) {
                --rtemp;
            }
            if (ltemp <= rtemp) {
                int tmp = arr[ltemp];
                arr[ltemp] = arr[rtemp];
                arr[rtemp] = tmp;
                --rtemp;
                ++ltemp;
            }
            if (ltemp == rtemp) {
                ltemp++;
            }
            if (left < rtemp) {
                quickSort(arr, left, ltemp - 1);
            }
            if (ltemp < right) {
                quickSort(arr, rtemp + 1, right);
            }
        }
    }
}
