package com.tazine.algorithm.playground;

import java.util.Arrays;

/**
 * InsertionSort
 *
 * @author frank
 * @since 1.0.0
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] a = {5, 1, 3, 2, 4};
        System.out.println(Arrays.toString(a));
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void insertSort(int[] arr) {
        int tmp, j;
        for (int i = 1; i < arr.length; i++) {
            j = i - 1;
            tmp = arr[i];
            while ((j >= 0) && (arr[j] > tmp)) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 找到 j 的时候停了， 那么 j+1 就是你的归宿
            arr[j + 1] = tmp;
        }
    }
}
