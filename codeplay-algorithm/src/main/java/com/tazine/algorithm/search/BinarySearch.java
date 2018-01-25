package com.tazine.algorithm.search;

import com.tazine.algorithm.sort.inner.BubbleSort;

import java.util.Scanner;

/**
 * 二分法查找
 * <p>
 * 条件：二分法查找需要数组必须是事先排好序的
 * <p>
 * 原理：首先确定该查找区间的中间点位置： int mid = (low+high) / 2；
 * 然后将待查找的值与中间点位置的值比较：若相等，则查找成功并返回此位置。
 * 若中间点位置值大于待查值，则新的查找区间是中间点位置的左边区域。
 * 若中间点位置值小于待查值，则新的查找区间是中间点位置的右边区域。
 * 下一次查找是针对新的查找区间进行的。
 *
 * @author Frank
 * @since 1.0.0
 */
public class BinarySearch {

    private static int[] arr = {
            2, 18, 9, 3, 12
    };

    /**
     * 标准二分法查找需要数组是排好序的
     *
     * @param array  目标数组
     * @param target 索引数字
     * @return
     */
    public int search(int[] array, int target) {

        int low = 0;
        int mid;
        int high = array.length - 1;

        int j = 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (target < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            j++;
        }
        return -1;
    }

    public static void main(String[] args) {

        BubbleSort bubbleSort = new BubbleSort();

        System.out.print("原始数组为：");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();

        arr = bubbleSort.sort(arr);
        System.out.print("冒泡排序后：");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        BinarySearch binarySearch = new BinarySearch();

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要查找的数字：");

        int input = sc.nextInt();

        int index = binarySearch.search(arr, input);

        if (index == -1) {
            System.out.println("查无此数！");
        } else {
            System.out.println("索引数字在数组中的位置是：" + index);
        }
    }
}
