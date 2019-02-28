package com.tazine.base.object.override;

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
        // 字符测试
        //strTest();

        // POJO 类型
        SimpleNbaPlayer simpleLebron = new SimpleNbaPlayer("james");
        SimpleNbaPlayer simpleHarden = new SimpleNbaPlayer("james");
        Map<SimpleNbaPlayer, Integer> map1 = new HashMap<>();
        map1.put(simpleHarden, 1);
        map1.put(simpleLebron, 23);

        System.out.println("lebron: " + simpleLebron.hashCode());
        System.out.println("harden: " + simpleHarden.hashCode());
        System.out.println("lebron == harden: " + (simpleLebron == simpleHarden));
        System.out.println("lebron.equals(harden): " + simpleHarden.equals(simpleLebron));
        System.out.println("map size: " + map1.size());
        System.out.println("lebron: " + map1.get(simpleLebron));
        System.out.println("harden: " + map1.get(simpleHarden));
        System.out.println();

        // Lombok有坑 @Data 会导致 hashCode相等 && equals 相等
        LomDataNbaPlayer lomLebron = new LomDataNbaPlayer("james");
        LomDataNbaPlayer lomHarden = new LomDataNbaPlayer("james");
        Map<LomDataNbaPlayer, Integer> map2 = new HashMap<>();
        map2.put(lomLebron, 23);
        map2.put(lomHarden, 1);

        System.out.println("lebron: " + lomLebron.hashCode());
        System.out.println("harden: " + lomHarden.hashCode());
        // false
        System.out.println("lebron == harden: " + (lomLebron == lomHarden));
        // true
        System.out.println("lebron.equals(harden): " + lomLebron.equals(lomHarden));
        // 1 后面放的会把前面的对象覆盖
        System.out.println("map size: " + map2.size());
        System.out.println("lebron: " + map2.get(lomLebron));
        System.out.println("harden: " + map2.get(lomHarden));
        System.out.println();

        // 只复写equals不复写 hashCode，这样违反了 hashCode 的通用约定
        OverrideEqualPlayer equalLebron = new OverrideEqualPlayer("james");
        OverrideEqualPlayer equalHarden = new OverrideEqualPlayer("james");
        Map<OverrideEqualPlayer, Integer> map3 = new HashMap<>();
        map3.put(equalLebron, 23);
        map3.put(equalHarden, 1);

        System.out.println("lebron: " + equalLebron.hashCode());
        System.out.println("harden: " + equalHarden.hashCode());
        // false
        System.out.println("lebron == harden: " + (equalLebron == equalHarden));
        // true
        System.out.println("lebron.equals(harden): " + equalLebron.equals(equalHarden));
        // 1 后面方的会把前面的对象覆盖
        System.out.println("map size: " + map3.size());
        System.out.println("lebron: " + map3.get(equalLebron));
        System.out.println("harden: " + map3.get(equalHarden));
        System.out.println();
    }

    private static void strTest() {
        String s1 = "james";
        String s2 = "james";
        String s3 = new String("james");
        String s4 = new String("james");

        System.out.println("s1: " + s1.hashCode());
        System.out.println("s2: " + s2.hashCode());
        System.out.println("s3: " + s3.hashCode());
        System.out.println("s4: " + s4.hashCode());
    }
}
