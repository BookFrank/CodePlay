package com.tazine.container.collection.set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by lina on 2018/1/11.
 *
 * @author frank
 * @since 1.0.0
 */
public class HashSetFeatures {

    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            set.add(rand.nextInt(30));
        }

        if (set.contains(20)){
            System.out.println("底层是 map.contains(key)");
        }

        System.out.println(set);
    }
}
