package com.tazine.codeplay.version.java8.stream.playground;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.tazine.codeplay.version.Student;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
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

        // 4. Map - 找出所有满族的学生的姓名
        List<String> names = students.stream().filter(s -> "满族".equals(s.getNation())).map(Student::getName).collect(
            Collectors.toList());
        System.out.println("满族学生的姓名：" + names);

        // 5. MapToInt - 获得所有学生的分数和
        int totalScore = students.stream().mapToInt(Student::getScore).sum();
        System.out.println("所有学生分数和：" + totalScore);

        // 6. Peek - 使用 Peek 给每个藏族学生 +10 分
        List<Student> plusStds = students.stream().filter(s -> "藏族".equals(s.getNation())).peek(
            s -> s.setScore(s.getScore() + 10)).collect(Collectors.toList());
        System.out.println("藏族学生：" + JSON.toJSONString(plusStds));

        // 7. Sorted(Comparator) - 将所有学生按分数从高到低排序
        List<Student> sortStds = students.stream().sorted(Comparator.comparingInt(Student::getScore).reversed())
            .collect(Collectors.toList());
        System.out.println("按分数排序：" + JSON.toJSONString(sortStds));

        // 8. groupBy - 使用 groupBy 将学生按省份分组
        Map<String, List<Student>> group1 = students.stream().collect(Collectors.groupingBy(Student::getProvince));
        System.out.println("按省份分组：" + JSON.toJSONString(group1));

        // 9. groupBy + counting - 求出各民族学生的人数
        Map<String, Long> group2 = students.stream().collect(
            Collectors.groupingBy(Student::getNation, Collectors.counting()));
        System.out.println("各民族学生人数：" + group2);

        // 10. groupBy - 二级分组，一级分组按地域，二级分组按民族
        Map<String, Map<String, List<Student>>> group3 = students.stream().collect(
            Collectors.groupingBy(Student::getProvince, Collectors.groupingBy(Student::getNation)));
        System.out.println("二级分组学生：" + JSON.toJSONString(group3));

        // 11. partitionBy - 将学生分区，分为汉族 + 非汉族
        Map<Boolean, List<Student>> group4 = students.stream().collect(
            Collectors.partitioningBy(s -> "汉族".equals(s.getNation())));
        System.out.println("汉族与非汉族：" + JSON.toJSONString(group4));

        // 12. reduce - 使用 reduce 聚合求出总分数
        int total = students.stream().map(Student::getScore).reduce(0, (a, b) -> a + b);
        System.out.println("总分为：" + total);

        // 13. Collectors.summingInt - 求总分数
        int total1 = students.stream().collect(Collectors.summingInt(Student::getScore));
        System.out.println("总分为：" + total1);

        // 14. Collectors.averagingInt - 求平均分
        double avgScore = students.stream().collect(Collectors.averagingInt(Student::getScore));
        System.out.println("平均分为：" + avgScore);

        // 15. Collectors.summarizingInt - 一次性得到元素个数、总和、均值、最大值、最小值
        IntSummaryStatistics summary = students.stream().collect(Collectors.summarizingInt(Student::getScore));
        System.out.println("分数总结情况：" + summary);
    }

    private static List<Student> getAllStudents() {

        Student s1 = new Student("张三", 320, 18, "河南", "汉族");
        Student s2 = new Student("李四", 520, 19, "上海", "汉族");
        Student s3 = new Student("王五", 320, 18, "北京", "汉族");
        Student s4 = new Student("陈六", 560, 18, "河南", "汉族");
        Student s5 = new Student("尼玛", 420, 18, "西藏", "藏族");
        Student s6 = new Student("阿布都", 460, 19, "新疆", "维吾尔族");
        Student s7 = new Student("梁洁", 450, 18, "北京", "满族");

        return Lists.newArrayList(s1, s2, s3, s4, s5, s6, s7);
    }
}
