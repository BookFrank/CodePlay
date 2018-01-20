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

        for (int i = 0; i < scores.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[min]) {
                    min = j;
                }
            }
            if (min != i){
                int tmp = scores[min];
                scores[min] = scores[i];
                scores[i] = tmp;
            }
        }
        System.out.println(Arrays.toString(scores));
    }
}
