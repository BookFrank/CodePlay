package com.tazine.container.utils;

import java.util.*;

/**
 * IteratorLive
 *
 * @author frank
 * @since 1.0.0
 */
public class IteratorLive {

    private static void display(Iterator it){
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Integer[] arr = {1,2,3,4,5};

        List<Integer> list1 = new ArrayList<>(Arrays.asList(arr));
        List<Integer> list2 = new LinkedList<>(Arrays.asList(arr));
        Set<Integer> list3 = new HashSet<>(Arrays.asList(arr));

        display(list1.iterator());
        display(list2.iterator());
        display(list3.iterator());
    }
}
