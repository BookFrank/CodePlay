package com.tazine.algorithm.playground;

import java.util.Arrays;

/**
 * BubbleSort
 *
 * @author frank
 * @since 1.0.0
 */
public class BubbleSort {


    public static void main(String[] args) {

        int[] scores = {23, 45, 64, 12, 56, 78, 98, 43, 12, 34, 76, 89, 78, 67, 19};

        for (int i = 0; i < scores.length - 1; i++) {
            for (int j = 0 ; j < scores.length - 1 - i ; j++){
                if (scores[j] > scores[j+1]){
                    int tmp = scores[j];
                    scores[j] = scores[j+1];
                    scores[j+1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(scores));
    }
}
