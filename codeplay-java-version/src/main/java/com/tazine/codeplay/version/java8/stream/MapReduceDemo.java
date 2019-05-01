package com.tazine.codeplay.version.java8.stream;

import com.google.common.collect.Lists;
import com.tazine.codeplay.version.Student;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Stream MapReduce
 *
 * @author frank
 * @date 2019-04-18
 */
public class MapReduceDemo {

    public static void main(String[] args) {

        Student zhangsan = new Student("zhangsan", 92);
        Student lisi = new Student("lisi", 89);
        Student wangwu = new Student("wangwu", 98);

        List<Student> students = Lists.newArrayList(zhangsan, lisi, wangwu);


        // map用来归类，结果一般是一组数据，比如可以将list中的学生分数映射到一个新的stream中。
        // reduce用来计算值，结果是一个值，比如计算最高分

        // 使用map方法获取list数据中的name
        List<String> names = students.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(names);

        // 使用map方法获取list数据中的name的长度
        List<Integer> length = students.stream().map(Student::getName).map(String::length).collect(Collectors.toList());
        System.out.println(length);

        //将每人的分数-10
        List<Integer> score = students.stream().map(Student::getScore).map(i -> i - 10).collect(Collectors.toList());
        System.out.println(score);

        //计算学生总分
        Integer totalScore1 = students.stream().map(Student::getScore).reduce(0,(a,b) -> a + b);
        System.out.println(totalScore1);

        //计算学生总分，返回Optional类型的数据，改类型是java8中新增的，主要用来避免空指针异常
        Optional<Integer> totalScore2 = students.stream().map(Student::getScore).reduce((a, b) -> a + b);
        System.out.println(totalScore2.get());

        //计算最高分和最低分
        Optional<Integer> max = students.stream().map(Student::getScore).reduce(Integer::max);
        Optional<Integer> min = students.stream().map(Student::getScore).reduce(Integer::min);

        System.out.println(max.get());
        System.out.println(min.get());
    }
}
