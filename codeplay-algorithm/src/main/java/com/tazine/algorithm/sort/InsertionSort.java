package com.tazine.algorithm.sort;

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
        shellSort(arr);
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
