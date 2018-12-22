package com.tazine.container.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * HashMapFeatures
 *
 * @author frank
 * @date 2018/1/11
 */
public class HashMapFeatures {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> table = new Hashtable<>();

        // HashMap 可以接受 null key 和 null value,
        // 除了非同步和允许 null之外，HashMap几乎和HashTable一样
        map.put(null, null);
        // table.put(null,null);

        map.put(1, "kobe");

        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.print(e.getKey() + " : " + e.getValue());
            System.out.println();
        }
    }
}
