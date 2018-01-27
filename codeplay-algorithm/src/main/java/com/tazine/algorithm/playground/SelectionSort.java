package com.tazine.algorithm.playground;

import java.util.Arrays;

/**
 * Selection Sort
 *
 * @author frank
 * @since 1.0.0
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] scores = {2, 1, 4, 3, 5, 6, 8, 7};
        selectSort(scores);
        System.out.println(Arrays.toString(scores));
    }

    public static void selectSort(int[] arr) {
        int minIndex, tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
        }
    }
}
