package com.tazine.algorithm.sort;

import java.util.Arrays;

/**
 * Created on 2017/10/12.
 *
 * 快速排序
 *
 * @author Frank
 */
public class QuickSort {

    private static final int[] arr = {
            5, 3, 4, 1, 2
    };



    public static void main(String[] args) {




        Arrays.sort(arr);

        for (int i : arr){
            System.out.println(i);
        }

    }


}
