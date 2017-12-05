package com.tazine.algorithm.sort;

/**
 * Created on 2017/12/4.
 * 直接插入排序法
 *
 * @author Frank
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arr = new int[]{20, 40, 90, 30, 80, 70, 50};
        System.out.println("排序前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        int tmp;
        int j;
        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
        }
        System.out.println("\n排序后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
