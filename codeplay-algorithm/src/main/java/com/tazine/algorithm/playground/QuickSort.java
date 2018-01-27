package com.tazine.algorithm.playground;

import java.util.Arrays;

/**
 * QuickSort Practice
 *
 * @author frank
 * @since 1.0.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {69, 62, 89, 37, 97, 17, 28, 49};
        //quickSort(arr, 0, arr.length - 1);
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int low, int high){
        if (low < high){
            int mid = getMiddle(arr, low, high);
            sort(arr, 0, mid-1);
            sort(arr, mid+1, high);
        }
    }

    private static int getMiddle(int[] arr, int low, int high) {
        int temp;
        int base = arr[low];
        int i = low;
        int j = high;
        while (i != j){
            while ((i < j) && (arr[j]) >= base){
                j--;
            }
            while ((i < j) && (arr[i] <= base)){
                i++;
            }
            if (i < j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[low] = arr[i];
        arr[i] = base;
        return i;
    }

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, base, tmp;
        if (low >= high) {
            return;
        }
        base = arr[low];
        i = low;
        j = high;
        while (i != j) {
            while ((arr[j] >= base) && (i < j)) {
                j--;
            }
            while ((arr[i] <= base) && (i < j)) {
                i++;
            }
            if (i < j) {
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
            System.out.println("i = " + i + " -- j = " + j);
            System.out.println(Arrays.toString(arr));
            System.out.println();
        }
        arr[low] = arr[i];
        arr[i] = base;
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }
}
