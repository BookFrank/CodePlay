package com.tazine.container.collection.set;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSetFeatures
 *
 * @author frank
 * @since 1.0.0
 */
public class TreeSetFeatures {

    public static void main(String[] args) {

        Random rand = new Random(47);

        // TreeSet 底层为 TreeMap
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < 10000; i++) {
            set.add(rand.nextInt(30));
        }

        // TreeSet 将元素存储在红-黑树中
        System.out.println(set);

    }
}
