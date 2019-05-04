package com.tazine.codeplay.version.java8.stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tazine.codeplay.version.NbaPlayer;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * StreamDemo
 *
 * @author frank
 * @date 2019/05/02
 */
public class StreamDemo {

    public static void main(String[] args) {

        NbaPlayer james = new NbaPlayer("james", 23, "lakers");
        NbaPlayer curry = new NbaPlayer("curry", 30, "warriors");
        NbaPlayer harden = new NbaPlayer("harden", 1, "rockets");
        NbaPlayer durant = new NbaPlayer("durant", 35, "warriors");
        NbaPlayer george = new NbaPlayer("george", 13, "thunder");

        List<NbaPlayer> allstars = Lists.newArrayList(james, durant, george, curry, harden);

        // 1. 分组
        Map<String, List<NbaPlayer>> group = allstars.stream().collect(Collectors.groupingBy(NbaPlayer::getTeam));
        // 2. 唯一属性分组，如果分组的属性是唯一的，上面的代码就很麻烦，可以使用Guava
        Map<String, NbaPlayer> starsMap = Maps.uniqueIndex(allstars, NbaPlayer::getName);
        // 3. 分组计数，计算各个属性分组计数
        Map<String, Long> group1 = allstars.stream().collect(
            Collectors.groupingBy(NbaPlayer::getTeam, Collectors.counting()));
        // 4. 非唯一属性分组，获取不同分组属性下的某一属性值
        Map<String, List<String>> group4 = allstars.stream().collect(
            Collectors.groupingBy(NbaPlayer::getTeam, Collectors.mapping(NbaPlayer::getName, Collectors.toList())));
        // 5. 二级分组
        Map<String, Map<String, List<NbaPlayer>>> group5 = allstars.stream().collect(
            Collectors.groupingBy(NbaPlayer::getSection, Collectors.groupingBy(NbaPlayer::getTeam)));
        // 6. 属性平均值
        double avgAge = allstars.stream().collect(Collectors.averagingInt(NbaPlayer::getAge));
        // 7. 属性和
        int totalAge = allstars.stream().collect(Collectors.summingInt(NbaPlayer::getAge));
        // 8. 一次性获取元素个数、总和、均值、最大值、最小值
        IntSummaryStatistics summary = allstars.stream().collect(Collectors.summarizingInt(NbaPlayer::getAge));
        // IntSummaryStatistics{count=24, sum=482, min=18, average=23, max=36}


        System.out.println(JSON.toJSONString(group));
        System.out.println(starsMap);
        System.out.println(group4);
        System.out.println(group5);
        System.out.println(group1);
        System.out.println(avgAge);
        System.out.println(totalAge);
        System.out.println(summary);

        // 根据整个实体对象分组计数，当其为string时常使用
        Map<NbaPlayer, Long> group2 = allstars.stream().collect(
            Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(JSON.toJSONString(group2));

        // 累加求和 根据属性分组，并统计其中一个属性值的sum或者avg
        Map<String, Integer> group3 = allstars.stream().collect(
            Collectors.groupingBy(NbaPlayer::getTeam, Collectors.summingInt(NbaPlayer::getNum)));
        System.out.println(group3);
    }
}
