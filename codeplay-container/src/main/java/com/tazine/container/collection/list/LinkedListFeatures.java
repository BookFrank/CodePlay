package com.tazine.container.collection.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedListFeatures
 *
 * @author frank
 * @date 2018/1/11
 */
public class LinkedListFeatures {


    public static void main(String[] args) {

        String[] words = {"A", "B", "C", "D", "E"};

        List<String> list = new LinkedList<>(Arrays.asList(words));

        System.out.println("原始 List : " + list);



    }


}
