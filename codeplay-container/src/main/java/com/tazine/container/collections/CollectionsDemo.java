package com.tazine.container.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections 类的方法
 */
public class CollectionsDemo {

    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>();
        List<Integer> list = Arrays.asList(1, 3, 2, 4, 5);
//        Collections.addAll(list, Arrays.asList(1,3,2,4,5));

        System.out.println(list);

//        System.out.println(Collections.binarySearch(list, 3));
        Collections.sort(list);
        System.out.println(list);


        System.out.println(Collections.min(list));

    }

}
