package com.tazine.collection;

import java.util.*;

/**
 * 集合框架之 List
 *
 * @author Frank
 */
public class ListDemo {


    public static void main(String[] args) {

        listIter();

    }

    private static void listIter(){
        List<Integer> list = new ArrayList<Integer>();

        Collections.addAll(list, 2,1,4,3,6,5);

        ListIterator<Integer> it = list.listIterator();

        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }

        System.out.println();
        while (it.hasPrevious()){
            System.out.print(it.previous() + " ");
        }
    }

}
