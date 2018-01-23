package com.tazine.algorithm.thinking;

/**
 * 基本算法思想之分治算法
 * 将一个复杂的问题分解为与原问题形式相同的小问题，递归调用解决这些小问题，最后综合结果
 *
 * @author frank
 * @since 1.0.0
 */
public class DivideAndConquer {

    public static void main(String[] args) {
        int[] conis = new int[30];
        for (int i = 0; i < 30; i++) {
            if (i == 4) {
                conis[i] = 0;
            } else {
                conis[i] = 1;
            }
        }
        int s = falseCoin(conis,0,29);
        System.out.println(s);
    }

    public static int falseCoin(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        System.out.println(low + " - " + mid + " - " + high);
        int left = 0, right = 0;

        if ((low + high) % 2 == 0) {
            for (int i = low; i <= high; i++) {
                if (i <= mid) {
                    left += arr[i];
                }
                if (i >= mid) {
                    right += arr[i];
                }
            }
        } else {
            for (int i = low; i <= high; i++) {
                if (i <= mid) {
                    left += arr[i];
                } else {
                    right += arr[i];
                }
            }
        }
        System.out.println(left + " ---- " + right);
        if (left < right) {
            System.out.println("left < right");
            if ((high - low) == 1) {
                return low;
            }
            System.out.println();
            return falseCoin(arr, low, mid);
        } else if (left > right) {
            System.out.println("left > right");
            if ((high - low) == 1) {
                return right;
            }
            System.out.println();
            return falseCoin(arr, mid, high);
        }else {
            return mid;
        }
    }
}
