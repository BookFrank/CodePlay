package com.tazine.codeplay.version.java8.stream.playground;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.tazine.codeplay.version.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * StreamPractice
 *
 * @author frank
 * @date 2019/05/04
 */
public class StreamPractice {

    public static void main(String[] args) {

        // Student{name="张三", score=320, age=18, province="河南"}
        List<Student> students = getAllStudents();
        List<Integer> numbers = Lists.newArrayList(1, 2, 3, 2, 8, 6, 9, 7, 4, 8);

        // 1. Filter - 使用 filter 找出所有上海的考生
        List<Student> shanghaiList = students.stream().filter(s -> "上海".equals(s.getProvince())).collect(
            Collectors.toList());
        System.out.println("来自上海的考生：" + JSON.toJSONString(shanghaiList));

        // 2. Distinct - 找出所有偶数并去重
        List<Integer> evenNums = numbers.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
        System.out.println("去重偶数为：" + evenNums);

        // 3. Limit - 使用 limit 找出2个来自河南的考生
        List<Student> henanStd = students.stream().filter(s -> "河南".equals(s.getProvince())).limit(2).collect(
            Collectors.toList());
        System.out.println("来自河南的2个考生：" + JSON.toJSONString(henanStd));

    }

    private static List<Student> getAllStudents() {

        Student s1 = new Student("张三", 320, 18, "河南");
        Student s2 = new Student("李四", 520, 19, "上海");
        Student s3 = new Student("王五", 320, 18, "北京");
        Student s4 = new Student("陈六", 320, 18, "河南");
        Student s5 = new Student("尼玛", 420, 18, "西藏");
        Student s6 = new Student("阿布都", 460, 19, "新疆");

        return Lists.newArrayList(s1, s2, s3, s4, s5, s6);
    }

}
