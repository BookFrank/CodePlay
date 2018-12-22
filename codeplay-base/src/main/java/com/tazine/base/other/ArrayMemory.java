package com.tazine.base.other;

/**
 * @author Frank
 * @date 2017/12/03
 */
public class ArrayMemory {

    public static void main(String[] args) {

        int num1 = 1024 * 2;
        int[] arr1 = new int[num1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
        }

        // 获得占用内存总数，并将单位转换为 MB
        long memory1 = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        System.out.println("一维数组存储占用内存总量为：" + memory1);

        int num2 = 1024 * 1024;
        int[][] arr2 = new int[num2][2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i][0] = i;
            arr2[i][1] = i;
        }
        long memory2 = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        System.out.println("二维数组存储占用内存总量为：" + memory2);
    }

}
