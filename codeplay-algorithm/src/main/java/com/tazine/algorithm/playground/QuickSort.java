package com.tazine.algorithm.playground;

import java.util.Arrays;

/**
 * Created by lina on 2018/1/22.
 *
 * @author frank
 * @since 1.0.0
 */
public class QuickSort {


    public static void main(String[] args) {

        int[] arr = {5, 1, 3, 2, 4};

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {

        int i = 0;
        int j = arr.length - 1;
        while (i < j){
            if (arr[j] > arr[0]){
                j--;
            }
            if (arr[i] < arr[0]){
                i++;
            }

        }

    }

}
