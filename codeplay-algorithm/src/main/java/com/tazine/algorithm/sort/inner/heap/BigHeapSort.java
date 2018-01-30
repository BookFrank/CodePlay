package com.tazine.algorithm.sort.inner.heap;

import java.util.Arrays;

/**
 * HeapSort
 *
 * @author frank
 * @since 1.0.0
 */
public class BigHeapSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 2, 3, 5, 6};
        System.out.println(Arrays.toString(arr));
        bigHeapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void bigHeapSort(int[] arr, int n) {

        int i, j, tmp;
        for (i = n / 2 - 1; i >= 0; i--) {
            while ((2 * i + 1) < n) {
                j = 2 * i + 1;
                if (j + 1 < n) {
                    if (arr[j + 1] > arr[j]) {
                        j++;
                    }
                }
                if (arr[j] > arr[i]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i = j;
                } else {
                    break;
                }
            }
        }
        tmp = arr[0];
        arr[0] = arr[n - 1];
        arr[n - 1] = tmp;
        if (n > 1) {
            bigHeapSort(arr, n - 1);
        }
    }
}
