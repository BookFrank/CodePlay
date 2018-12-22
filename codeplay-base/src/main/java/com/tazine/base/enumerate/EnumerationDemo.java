package com.tazine.base.enumerate;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Enumberation 接口的作用与 Iterator类似，只提供了遍历 Vector 和 HashTable 类型集合元素的功能，不支持元素的移除操作。
 *
 * @author frank
 * @date 2017/12/27
 */
public class EnumerationDemo {

    public static void main(String[] args) {

        Hashtable<String, Integer> table = new Hashtable<>();
        table.put("A", 10);
        table.put("B", 11);
        table.put("C", 12);

        Enumeration ints = table.elements();
        while (ints.hasMoreElements()){
            System.out.println(ints.nextElement());
        }
    }

}
