package com.tazine.container.utils;

import java.util.Arrays;

/**
 * 数组相关操作
 *
 * @author frank
 * @since 1.0.0
 */
public class ArraysActions {

    public static void main(String[] args) {

        int[] a;  // Local uninitialized variable

        // The references inside the array are automatically initialized to null
        ArraysActions[] b = new ArraysActions[2];
        System.out.println(Arrays.toString(b));

        // Aggregate initialization 聚集初始化
        ArraysActions[] c = {new ArraysActions(), new ArraysActions()};
        System.out.println(Arrays.toString(c));

        // Dynamic initialization
        ArraysActions[] d = new ArraysActions[]{new ArraysActions(), new ArraysActions()};
        System.out.println(Arrays.toString(d));
    }

}
