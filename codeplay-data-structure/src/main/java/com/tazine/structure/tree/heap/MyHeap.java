package com.tazine.structure.tree.heap;

import java.util.Arrays;

/**
 * Heap
 *
 * @author frank
 * @date 2018/01/27
 */
public class MyHeap {


    public static void main(String[] args) {

        int[] arr = {8, 1, 3, 2, 4, 6, 7, 5};
        System.out.println(Arrays.toString(arr));
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr, int n) {

        if (n == 1) {
            return;
        }

        int i, j, h, k;
        int tmp;

        // 构建a[0,n-1] 的最大堆，n/2-1 取得是第一个非叶节点的数组下标
        for (i = n / 2 - 1; i >= 0; i--) {
            System.out.println("该非叶节点的下标为 " + i + "，其值为 " + arr[i]);
            // 2*i+1 得到的是第i个节点左子树的下标
            while (2 * i + 1 < n) {
                // j 代表左子树节点的数组下标
                j = 2 * i + 1;
                if ((j + 1) < n) {
                    System.out.println("xiaoyu");
                    if (arr[j] < arr[j + 1]) {
                        j++;
                    }
                }
                if (arr[i] < arr[j]) {
                    System.out.println("--");
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    // 堆被破坏，需要重新调整
                    //i = j;
                } else {
                    break;
                }
                System.out.println(Arrays.toString(arr));
            }
        }

        tmp = arr[n - 1];
        arr[n - 1] = arr[0];
        arr[0] = tmp;
        //heapSort(arr, n-1);
    }


}
