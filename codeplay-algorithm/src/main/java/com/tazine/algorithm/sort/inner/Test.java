package com.tazine.algorithm.sort.inner;

import java.util.Arrays;

/**
 * Test
 *
 * @author frank
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {

        int[] arr = {2, 1, 5, 4, 3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int base = arr[low];
        int temp;
        while (i != j) {
            while ((i < j) && (arr[j] >= base)) {
                j--;
            }
            while ((i < j) && (arr[i] <= base)) {
                i++;
            }
            if (i < j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[low] = arr[i];
        arr[i] = base;
        quickSort(arr, 0, i - 1);
        quickSort(arr, i + 1, high);
    }

}
