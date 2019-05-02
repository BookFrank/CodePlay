package com.tazine.codeplay.version.java8.stream;

import com.google.common.collect.Lists;
import com.tazine.codeplay.version.NbaPlayer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ParallelStreamDemo
 *
 * @author frank
 * @date 2018/04/23
 */
public class ParallelStreamDemo {

    public static void main(String[] args) {

        // 可以通过 list.stream 将List类型转换为流类型，还可以通过list.parallelStream()转换为并行流
        NbaPlayer james = new NbaPlayer("james", 23, "lakers");
        NbaPlayer durant = new NbaPlayer("durant", 35, "warriors");
        NbaPlayer george = new NbaPlayer("george", 13, "thunder");
        NbaPlayer curry = new NbaPlayer("curry", 30 , "warriors");
        NbaPlayer harden = new NbaPlayer("harden", 1, "rockets");

        List<NbaPlayer> allstars = Lists.newArrayList(james, durant, george, curry, harden);

        List<String> warriorsPlayers = allstars.parallelStream().filter(v -> v.getTeam().equalsIgnoreCase("warriors"))
            .sorted(Comparator.comparingInt(NbaPlayer::getNum).reversed())
            .map(NbaPlayer::getName)
            .collect(Collectors.toList());
        System.out.println(warriorsPlayers);
    }
}
