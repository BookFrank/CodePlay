package com.tazine.algorithm.sort.inner.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * HeapSort
 *
 * @author frank
 * @since 1.0.0
 */
public class SmallHeapSort {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 2, 3, 5, 6};
        System.out.println(Arrays.toString(arr));
        tinyHeapSort(arr, arr.length);
        System.out.println(list);
    }

    private static void tinyHeapSort(int[] arr, int n) {

        int i, j, temp;
        for (i = n / 2 - 1; i >= 0; i--) {
            while ((2 * i + 1) < n) {
                j = 2 * i + 1;
                if (j + 1 < n) {
                    if (arr[j + 1] < arr[j]) {
                        j++;
                    }
                }
                if (arr[j] < arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i = j;
                }
            }
        }
        if (n >= 1) {
            list.add(arr[0]);
            tinyHeapSort(arr, n - 1);
        }
    }
}
