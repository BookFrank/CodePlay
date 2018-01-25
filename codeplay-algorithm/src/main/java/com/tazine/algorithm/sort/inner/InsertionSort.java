package com.tazine.algorithm.sort.inner;

import java.util.Arrays;

/**
 * 直接插入排序法
 *
 * @author frank
 * @since 1.0.0
 */
public class InsertionSort {

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{20, 40, 90, 30, 80, 70, 50};
//        System.out.println("排序前：");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }


        //insertionSort(arr);
        insertSort(arr);
        shellSort(arr);
    }

    /**
     * 外层循环中的 i 表示本次计算中需要完成插入任务的数组元素，
     * 首先将需要插入的元素保存在 tmp 中，变量 j 表示需要插入的位置
     * 内层 while 循环就是为了寻找 j 的位置，通过 arr[j] 和 tmp 变量的比较
     * 当arr[j] > tmp 时，就把 j 当前的元素向后移动，直到找到比tmp变量小的元素时停止。
     * 此时 j + 1，这个位置就是本次数组元素应该插入的位置，同时别的元素也都完成了移动。
     *
     * @param arr
     */
    private static void insertSort(Integer[] arr) {
        int tmp, j;
        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i]; // 需要插入的元素保存到变量t中
            j = i - 1;
            while ((j >= 0) && (arr[j] > tmp)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 希尔排序：直接插入排序的一种，是冲破二次时间屏障的第一批算法。
     *
     * @param t
     * @param <T>
     */
    private static <T extends Comparable<? super T>> void shellSort(T[] t) {

        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
        //希尔排序
        int d = a.length;
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < a.length; i = i + d) {
                    int temp = a[i];
                    int j;
                    for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }


    private static <T extends Comparable<? super T>> void insertionSort(T[] t) {

        T tmp;
        int j;
        for (int i = 1; i < t.length; i++) {
            tmp = t[i];
            for (j = i - 1; (j >= 0) && tmp.compareTo(t[j]) < 0; j--) {
                t[j + 1] = t[j];
            }
            t[j + 1] = tmp;
        }
        System.out.println("\n排序后：");
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i] + " ");
        }
    }

}
