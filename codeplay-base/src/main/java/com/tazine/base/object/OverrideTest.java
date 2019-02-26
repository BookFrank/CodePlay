package com.tazine.base.object;

import java.util.HashMap;
import java.util.Map;

/**
 * OverrideTest
 *
 * @author frank
 * @date 2018/02/22
 */
public class OverrideTest {

    public static void main(String[] args) {

        Map<NbaPlayer, Integer> map1 = new HashMap<>();

        NbaPlayer leborn = new NbaPlayer("james");
        NbaPlayer harden = new NbaPlayer("james");

        map1.put(leborn, 23);
        map1.put(harden, 1);

        // false
        System.out.println(leborn == harden);
        // true
        System.out.println(leborn.equals(harden));

        System.out.println(map1.get(leborn));
        System.out.println(map1.get(harden));


    }
}
