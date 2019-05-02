package com.tazine.codeplay.version.java8.stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.tazine.codeplay.version.NbaPlayer;

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
        NbaPlayer curry = new NbaPlayer("curry", 30 , "warriors");
        NbaPlayer harden = new NbaPlayer("harden", 1, "rockets");
        NbaPlayer durant = new NbaPlayer("durant", 35, "warriors");
        NbaPlayer george = new NbaPlayer("george", 13, "thunder");

        List<NbaPlayer> allstars = Lists.newArrayList(james, durant, george, curry, harden);

        // 根据某个属性分组计数
        Map<String,Long> group = allstars.stream().collect(Collectors.groupingBy(NbaPlayer::getTeam, Collectors.counting()));
        System.out.println(group);

        // 根据整个实体对象分组计数，当其为string时常使用
        Map<NbaPlayer,Long> group1 = allstars.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(JSON.toJSONString(group1));

        // 根据属性分组，并统计其中一个属性值的sum或者avg
        Map<String,Integer> group2 = allstars.stream().collect(Collectors.groupingBy(NbaPlayer::getTeam,Collectors.summingInt(NbaPlayer::getNum)));
        System.out.println(group2);
    }
}
