package com.tazine.container;

import java.util.*;

/**
 * 集合框架之Set
 *
 * @author frank
 * @date 2018/1/11
 */
public class SetDemo {

    public static void main(String[] args) {
        //setRemoveDouble();
        setAdd();
    }

    private static void setAdd() {
        Set<Integer> set = new HashSet<Integer>();

        Collections.addAll(set, 2, 1, 3, 4, 6, 5, 7, 8);


        for (int i : set) {
            System.out.print(i + " ");
        }
    }

    /**
     * 利用 Set 的 addAll() 方法完成去重操作
     */
    private static void setRemoveDouble() {
        List<String> list = new ArrayList<String>();
        list.add("apple");
        list.add("xiaomi");
        list.add("huawei");
        list.add("apple");

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();
        Set<String> set = new HashSet<String>();
        set.addAll(list);

        for (String s : set) {
            System.out.print(s + " ");
        }
    }
}
