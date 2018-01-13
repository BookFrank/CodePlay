package com.tazine.container.collection.set;

import javax.swing.text.html.HTMLDocument;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by lina on 2018/1/13.
 *
 * @author frank
 * @since 1.0.0
 */
public class LinkedHashSetFeatures {


    public static void main(String[] args) {



        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(3);
        set1.add(7);
        set1.add(2);
        set1.add(1);

        set2.add(3);
        set2.add(7);
        set2.add(2);
        set2.add(1);

        Iterator<Integer> it = set1.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();

        Iterator<Integer> it1 = set2.iterator();
        while (it1.hasNext()){
            System.out.print(it1.next() + " ");
        }

    }



}
