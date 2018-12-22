package com.tazine.container.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组相关操作
 *
 * @author frank
 * @date 2018/1/11
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

        List<Integer> list = Arrays.asList(2, 1, 4, 3, 5);
        List<String> strings = new ArrayList<>();
        strings.addAll(Arrays.asList("kobe", "james", "iverson", "jordan"));

        int[]  ints = {1,2,3,4,5};
        System.out.println(Arrays.toString(Arrays.copyOf(ints,4)));

    }

}
