package com.tazine.algorithm.sort.inner;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author frank
 * @since 1.0.0
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] a = {11, 1, 32, 14, 23, 77};
        System.out.println(Arrays.toString(a));
        System.out.println();
        sort(a);
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex){
                int tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
            System.out.println(Arrays.toString(arr));;
        }
    }

}
