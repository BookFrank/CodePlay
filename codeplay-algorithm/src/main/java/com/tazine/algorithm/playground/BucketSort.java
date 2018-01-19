package com.tazine.algorithm.playground;

/**
 * BucketSort
 *
 * @author frank
 * @since 1.0.0
 */
public class BucketSort {

    public static void main(String[] args) {

        int[] scores = {2, 5, 1, 7, 4, 8, 5};

        int[] sorts = new int[10];

        for (int i : scores) {
            sorts[i]++;
        }

        // 正序
        for (int i = 0; i < sorts.length; i++) {
            int tmp = sorts[i];
            while (tmp-- != 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();

        for (int i = sorts.length - 1; i > 0; i--) {
            int tmp = sorts[i];
            while (tmp-- != 0) {
                System.out.print(i + " ");
            }
        }
    }
}
