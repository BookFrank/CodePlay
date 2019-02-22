package com.tazine.base.object;

import com.tazine.base.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * ObjectTest
 *
 * @author frank
 * @date 2018/02/22
 */
public class ObjectTest {

    public static void main(String[] args) {

        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = new String("hello");

        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println("s3.equals(s4):" + (s3.equals(s4)));
        System.out.println(s3 == s4);
        System.out.println();

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println();

        // s2 对象重新赋值，其 hashCode 会变
        s2 = "world";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println();

        Player kobe = new Player("kobe", 8);
        Player james = new Player("james", 23);
        System.out.println(kobe.hashCode());
        System.out.println(james.hashCode());
        System.out.println();

        // 重新设置对象的属性，hashcode 不会变
        kobe.setNum(24);
        System.out.println("kobe:" + kobe.hashCode());
        System.out.println("james:" + james.hashCode());
        System.out.println();

        // 更改List元素，hashCode 可能会变，因为 hashCode 是根据对象内部信息生成的，对象信息变了，hashCode可能就会变
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        System.out.println("list.hashcode:" + list.hashCode());
        list.add(3L);
        System.out.println("list.hashcode:" + list.hashCode());
    }
}
