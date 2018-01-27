package com.tazine.container.collection.set.cases.stud;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author frank
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {

        Set<Student> set = new HashSet<>();

        Student s1 = new Student(1, "kobe");
        Student s2 = new Student(1, "james");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        set.add(s1);
        System.out.println(set);
        s1.setSno(2);

        Iterator<Student> it = set.iterator();
        System.out.println(s1.equals(it.next()));
        set.add(s1);

        System.out.println(set);
    }

}
