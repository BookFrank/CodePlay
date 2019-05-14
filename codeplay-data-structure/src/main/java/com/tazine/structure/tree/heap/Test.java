package com.tazine.structure.tree.heap;

import java.util.Arrays;

/**
 * Heap Review
 *
 * @author frank
 * @date 2018/01/27
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {8, 1, 3, 2, 4, 6, 7, 5};
        System.out.println(Arrays.toString(arr));
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr, int n) {

        int i, j, tmp;
        for (i = n / 2 - 1; i >= 0; i--) {
            // 如果有左子树的话，这里使用while是因为，有可能发生 i=j，这时候要重新对其交换后的排序
            while (2 * i + 1 < n) {
                j = 2 * i + 1;
                if (j + 1 < n) {
                    // 如果进入这里，表明有右子树，对比左右子树，找出较大的
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

        // 将堆顶数据放到数组尾部，然后将数组-1，继续堆排序
        tmp = arr[0];
        arr[0] = arr[n - 1];
        arr[n - 1] = tmp;
        if (n - 1 > 1) {
            heapSort(arr, n - 1);
        }
    }
}
