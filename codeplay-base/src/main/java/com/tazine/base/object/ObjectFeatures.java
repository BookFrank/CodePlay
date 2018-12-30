package com.tazine.base.object;

/**
 * ObjectFeatures
 *
 * @author frank
 * @date 2017/12/27
 */
public class ObjectFeatures {

    public static void main(String[] args) {

        Object obj = new Object();
        Object obj1 = obj;
        Object obj2 = obj;

        // 比较的是真实对象的 地址值，而不是两个引用相等不相等
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1 == obj2);

    }

}
