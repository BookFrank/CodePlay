package com.tazine.container.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * 集合框架之 List
 *
 * @author Frank
 * @since 1.0.0
 */
public class ListDemo {

    /*
        list.contains() 方法最终还是使用 Object.equals()方法比较
        包装类型（Integer、String）使用 equals 比较的是值
        自定义类型比较的是 reference 地址
     */

    public static void main(String[] args) {
        contain();
    }

    static void contain() {
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(i1);
        if (list1.contains(i2)) {
            System.out.println("list1.contains(i2) : true");
        }

        String s1 = new String("apple");
        String s2 = new String("apple");
        List<String> list2 = new ArrayList<>();
        list2.add(s1);
        if (list2.contains(s2)) {
            System.out.println("list2.contains(s2) : true");
        }

        Player p1 = new Player(10);
        Player p2 = new Player(10);
        List<Player> plist = new ArrayList<>();
        plist.add(p1);
        if (plist.contains(p2)) {
            System.out.println("自定义类型相等");
        } else {
            System.out.println("自定义类型不相等");
        }
    }

    private static void listIter() {
        List<Integer> list = new ArrayList<Integer>();

        Collections.addAll(list, 2, 1, 4, 3, 6, 5);

        ListIterator<Integer> it = list.listIterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println();
        while (it.hasPrevious()) {
            System.out.print(it.previous() + " ");
        }
    }
}

class Player {
    private int age;
    public Player(int age) {
        this.age = age;
    }
}
