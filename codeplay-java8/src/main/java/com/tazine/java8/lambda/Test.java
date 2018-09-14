package com.tazine.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Java8 - Duration类
 *
 * @author frank
 * @since 1.0.0
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
        System.out.println(map);
    }
}
