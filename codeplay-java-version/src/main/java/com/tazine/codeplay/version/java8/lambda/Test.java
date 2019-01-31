package com.tazine.codeplay.version.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Java8 - Duration类
 *
 * @author frank
 * @date 2018/09/14
 */
public class Test {

    public static void main(String[] args) {

        Arrays.asList(1, 2, 3).forEach(System.out::println);

        List<Player> list = new ArrayList<>();

        for (int i = 1; i < 6; i++) {
            Player p = new Player(i + "号球员", i);
            list.add(p);
        }

        list.forEach(v -> System.out.println(v.getName()));

        // List 取某个字段
        List<String> names = list.stream().map(Player::getName).collect(Collectors.toList());
        System.out.println(names);

        // List 转 Map
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(Player::getName, Player::getNum));
        Map<String, Player> pmap = list.stream().collect(Collectors.toMap(Player::getName, p -> p,(p1,p2)->p1));
        System.out.println(map);
        System.out.println(pmap);
    }
}
