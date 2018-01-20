package com.tazine.algorithm.playground;

import java.util.Arrays;

/**
 * InsertionSort
 *
 * @author frank
 * @since 1.0.0
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] a = {118, 101, 105, 127, 112};

        // TODO 待审查算法
        for (int i = 1; i < a.length; i++) {

            for (int j = 0; j < i; j++) {
                if (a[j] > a[i]){
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
            System.out.println(Arrays.toString(a));
        }
    }

}
