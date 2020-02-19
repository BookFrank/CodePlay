package com.tazine.codeplay.version.java8.stream.playground;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.tazine.codeplay.version.NbaPlayer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ListStreamDemo
 *
 * @author jiaer.ly
 * @date 2020/02/03
 */
public class ListStreamDemo {

    public static void main(String[] args) {
        //removeIf();

        reduce();
    }

    private static void reduce() {
        NbaPlayer kobe1 = new NbaPlayer("kobe", 24);
        NbaPlayer kobe2 = new NbaPlayer("kobe", 8);
        NbaPlayer james1 = new NbaPlayer("james", 23);
        NbaPlayer james2 = new NbaPlayer("james", 5);

        List<NbaPlayer> list = Lists.newArrayList(kobe1, james1, kobe2, james2);

        List<NbaPlayer> result = Lists.newArrayList();
        // reduce 的核心理念就是先根据某一条件分组，然后对分组的数据进行两两处理 a,b
        list.stream().collect(Collectors.groupingBy(NbaPlayer::getName)).forEach((name, players) -> {
            players.stream().reduce((a,b) -> new NbaPlayer(name, a.getNum()+b.getNum())).ifPresent(result::add);
        });
        System.out.println(JSON.toJSONString(result));
    }

    private static void removeIf() {
        List<NbaPlayer> players = getPlayers();
        System.out.println(players.size());
        players.removeIf(v -> !v.getName().equalsIgnoreCase("kobe"));
        System.out.println(players.size());
    }

    private static List<NbaPlayer> getPlayers() {
        NbaPlayer kobe = new NbaPlayer("kobe", 24);
        NbaPlayer james = new NbaPlayer("james", 23);
        NbaPlayer iverson = new NbaPlayer("iverson", 3);
        NbaPlayer rose = new NbaPlayer("rose", 1);

        return Lists.newArrayList(kobe, james, iverson, rose);
    }
}
