package com.tazine.codeplay.version.java8.stream.ppt;

import com.google.common.collect.Lists;
import com.tazine.codeplay.version.Student;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author frank
 * @date 2019/05/02
 */
public class Test {

    public static void main(String[] args) {

        // 求出其中所有偶数的和
        List<Integer> numbers = Lists.newArrayList(12, 2, 31, 24, 53, 36, 7, 18, 91, 10);
        //int total = 0;
        //for (int i : numbers){
        //    if (i % 2 == 0){
        //        total+=i;
        //    }
        //}

        //List<Integer> sort = numbers.stream().sorted().collect(Collectors.toList());
        //System.out.println(sort);

        // 求出其中所有偶数的和
        //int total = numbers.stream().filter(v -> v % 2 == 0).mapToInt(Integer::intValue).sum();


        //System.out.println(total);



        Student frank = new Student("frank", 92);
        Student jason = new Student("jason", 89);
        Student peter = new Student("peter", 98);
        List<Student> students = Lists.newArrayList(frank, jason, peter);

        // 使用 reduce 规约
        int total = students.stream().map(Student::getScore).reduce(0,(a,b) -> a + b);

        // 使用 reduce 规约，返回 Optional
        Optional<Integer> total1 = students.stream().map(Student::getScore).reduce((a, b) -> a + b);
        Optional<Integer> total2 = students.stream().map(Student::getScore).reduce(Integer::sum);

        // 使用 mapToInt 转为 IntStream，省去拆装箱成本
        int total3 = students.stream().mapToInt(Student::getScore).sum();


        System.out.println(total);
        System.out.println(total1);
        System.out.println(total2);
        System.out.println(total3);





    }

}
