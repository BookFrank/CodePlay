package com.tazine.algorithm.playground;

import java.util.Arrays;

/**
 * ShellSort Practice
 *
 * @author frank
 * @since 1.0.0
 */
public class ShellSort {

    public static void main(String[] args) {

        int[] arr = {5, 1, 3, 2, 4};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void shellSort(int[] arr) {
        int tmp, j;
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                tmp = arr[i];
                j = i - gap;
                while ((j >= 0) && (arr[j] > tmp)) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
        }
    }
}
