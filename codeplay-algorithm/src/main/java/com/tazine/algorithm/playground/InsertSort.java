package com.tazine.algorithm.playground;

import java.util.Arrays;

/**
 * InsertSort Review
 *
 * @author frank
 * @since 1.0.0
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arr = {5, 3, 1, 4, 2, 8, 6};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {

        int temp, j;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            j = i - 1;
            while ((j >= 0) && (arr[j] > temp)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

}
