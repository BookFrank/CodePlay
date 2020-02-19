package com.tazine.codeplay.version.java8.stream.playground;

import com.google.common.collect.Lists;
import com.tazine.codeplay.version.NbaPlayer;

import java.util.List;

/**
 * ListStreamDemo
 *
 * @author jiaer.ly
 * @date 2020/02/03
 */
public class ListStreamDemo {

    public static void main(String[] args) {

        //NbaPlayer kobe1 = new NbaPlayer("kobe", 24);
        //NbaPlayer kobe2 = new NbaPlayer("kobe", 24);
        //NbaPlayer james1 = new NbaPlayer("james", 23);
        //NbaPlayer james2 = new NbaPlayer("james", 5);
        //
        //List<NbaPlayer> l1 = Lists.newArrayList(kobe1, james1);
        //List<NbaPlayer> l2 = Lists.newArrayList(kobe2, james2);
        //
        //l1.addAll(l2);
        //
        ////
        //List<NbaPlayer> result = Lists.newArrayList();
        //l1.stream().collect(Collectors.groupingBy(NbaPlayer::getName)).forEach((name, p) -> {
        //    p.stream().reduce((a,b) -> new NbaPlayer(a.getName(), a.getNum() + b.getNum())).ifPresent(result::add);
        //});
        //System.out.println(JSON.toJSONString(result));

        removeIf();
    }

    public static void removeIf() {
        List<NbaPlayer> players = getPlayers();
        System.out.println(players.size());
        players.removeIf(v -> !v.getName().equalsIgnoreCase("kobe"));
        System.out.println(players.size());
    }

    public static List<NbaPlayer> getPlayers() {
        NbaPlayer kobe = new NbaPlayer("kobe", 24);
        NbaPlayer james = new NbaPlayer("james", 23);
        NbaPlayer iverson = new NbaPlayer("iverson", 3);
        NbaPlayer rose = new NbaPlayer("rose", 1);

        return Lists.newArrayList(kobe, james, iverson, rose);
    }
}
