package com.tazine.algorithm.sort.inner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 冒泡排序
 * 冒泡排序的核心部分是双重嵌套循环。不难看出冒泡排序的时间复杂度是O(N2)
 *
 * @author frank
 * @date 2017/10/15
 */
public class BubbleSort {

    /**
     * 双重嵌套循环，核心是弄清楚外层是什么逻辑，内层是什么逻辑
     * N个数排序，外层需要循环N-1次，外层不控制内层的任何东西,内层需循环N-i次
     */
    public static class Member {

        private String name;
        private double score;

        public Member(String name, double score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }

    private static List<Member> members = new ArrayList<Member>() {
        {
            add(new Member("赵", 5.0));
            add(new Member("钱", 12.5));
            add(new Member("孙", 8.6));
            add(new Member("李", 87.0));
            add(new Member("周", 56.8));
            add(new Member("吴", 37.9));
            add(new Member("郑", 98.2));
            add(new Member("王", 25.6));
            add(new Member("梁", 45.8));
            add(new Member("张", 66.6));
        }
    };


    /**
     * 整型冒泡排序
     *
     * @param array
     * @return
     */
    public int[] sort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public double[] sort(double[] array) {
        double temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j + 1] < array[j]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    private void bubble() {
        int[] arr = new int[]{63, 4, 24, 1, 3, 13};
        System.out.println("冒泡排序的过程是：");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
                System.out.print(arr[j] + "");
            }
            System.out.print("[");
            for (int j = arr.length - i; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < members.size(); i++) {
            for (int j = 0; j < members.size(); j++) {
                if (members.get(i).getScore() > members.get(j).getScore()) {
                    Member member = members.get(i);
                    members.set(i, members.get(j));
                    members.set(j, member);
                }
            }
        }

        Iterator<Member> it = members.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getName() + " - " + it.next().getScore());
        }

        int[] arr = {63, 4, 24, 1, 3, 13};
        System.out.println("冒泡排序的过程是：");
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
                System.out.print(arr[j] + " ");
            }
            System.out.print("[");
            for (int j = arr.length - i; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println("]");
        }


    }

}
