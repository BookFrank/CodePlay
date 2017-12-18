package com.tazine.container;

import java.util.Arrays;

/**
 * 数组相关操作
 *
 * @author frank
 * @since 1.0.0
 */
public class ArrayOptions {

    public static void main(String[] args) {

        int[] a;  // Local uninitialized variable

        // The references inside the array are automatically initialized to null
        ArrayOptions[] b = new ArrayOptions[2];
        System.out.println(Arrays.toString(b));

        // Aggregate initialization 集初始化
        ArrayOptions[] c = {new ArrayOptions(), new ArrayOptions()};
        System.out.println(Arrays.toString(c));

        // Dynamic initialization
        ArrayOptions[] d = new ArrayOptions[]{new ArrayOptions(), new ArrayOptions()};
        System.out.println(Arrays.toString(d));
    }

}
