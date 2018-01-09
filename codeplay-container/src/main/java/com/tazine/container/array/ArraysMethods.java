package com.tazine.container.array;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays API
 *
 * @author frank
 * @since 1.0.0
 */
public class ArraysMethods {

    public static void main(String[] args) {

        Integer[] cards = new Integer[]{1, 2, 3, 4, 5, 6, 7};

        // 数组 转 List
        List<Integer> list = Arrays.asList(cards);
        System.out.println(list);

        // list 转 数组
        Integer[] newCards = list.toArray(new Integer[cards.length]);
        System.out.println(Arrays.toString(newCards));
    }
}
