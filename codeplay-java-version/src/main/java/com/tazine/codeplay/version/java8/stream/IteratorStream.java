package com.tazine.codeplay.version.java8.stream;

import com.google.common.collect.Lists;
import com.tazine.codeplay.version.Student;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 在不存在Stream之前使用Iterator，也就是Java8之前是什么样子
 *
 * @author frank
 * @date 2019/04/22
 */
public class IteratorStream {

    public static void main(String[] args) {

        Student jason = new Student("jason", 92);
        Student peter = new Student("peter", 59);
        Student frank = new Student("frank", 98);

        List<Student> students = Lists.newArrayList(jason, peter, frank);

        //students = students.stream().filter(v -> v.getScore() > 90).collect(Collectors.toList());
        remove(students);

        // 找出考的最好的学生
        for (Student s : students) {
            System.out.println(s.getName());
        }

        // 在 Java 8 之前，都是使用外部迭代来实现目的
        // 外部迭代：由客户程序来处理List的迭代过程
        //List<Integer> intList = Lists.newArrayList(59, 89, 92, 98, 67);
        //int passedTotal = sumIterator(intList);
        //System.out.println("及格学生的总分" + passedTotal + ", 平均分" + passedTotal / 4);
    }

    private static void remove(List<Student> students){
        students = students.stream().filter(v -> v.getScore() > 90).collect(Collectors.toList());
        for (Student s : students) {
            System.out.println(s.getName());
        }
    }

    /**
     * 60分及格，求出及格学生的平均分
     *
     * @param list List<Integer>
     * @return int
     */
    private static int sumIterator(List<Integer> list) {
        int sum = 0;
        //for (Integer i : list){
        //    if (i >= 60){
        //        sum+=i;
        //    }
        //}
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int score = it.next();
            if (score >= 60) {
                sum += score;
            }
        }
        return sum;
    }

    /**
     * Write above logic in a single line statement using Java Streams
     *
     * @param list List<Integer>
     * @return int
     */
    private static int sumStream(List<Integer> list) {
        return list.stream().filter(i -> i >= 60).mapToInt(i -> i).sum();
    }
}
