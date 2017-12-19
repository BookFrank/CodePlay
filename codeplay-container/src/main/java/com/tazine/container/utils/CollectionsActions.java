package com.tazine.container.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections 类的方法
 */
public class CollectionsActions {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Collections.addAll(list, 3, 1, 2, 5, 4);

        System.out.println(list);

//        System.out.println(Collections.binarySearch(list, 3));
        Collections.sort(list);
        System.out.println(list);


        System.out.println(Collections.min(list));

    }

}
