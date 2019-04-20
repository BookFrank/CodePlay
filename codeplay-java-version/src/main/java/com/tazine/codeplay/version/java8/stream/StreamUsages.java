package com.tazine.codeplay.version.java8.stream;

import com.google.common.collect.Lists;
import com.tazine.codeplay.version.NbaPlayer;
import com.tazine.codeplay.version.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

/**
 * Common Stream Usages
 *
 * @author frank
 * @date 2018/03/14
 */
public class StreamUsages {

    public static void main(String[] args) {
        //constructStream();

        peekDemo();

        //flatMap();

        //listFilter();
    }

    private static void peekDemo() {
        Student zhangsan = new Student("zhangsan", 92);
        Student lisi = new Student("lisi", 89);
        Student wangwu = new Student("wangwu", 98);

        List<Student> students = Lists.newArrayList(zhangsan, lisi, wangwu);
        List<Integer> scores = students.stream().peek(e -> {
            if (e.getScore() < 90){
                e.setScore(90);
            }
        }).map(Student::getScore).collect(Collectors.toList());
        System.out.println(scores);
    }

    private static void constructStream() {
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");
        // 2. Arrays
        String [] strArray = new String[] {"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();

        // 数值流的构造
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
        //LongStream.of(1L, 2L);
        //DoubleStream
    }

    /**
     * List 根据条件过滤
     */
    private static void listFilter() {
        NbaPlayer p1 = new NbaPlayer("kobe", 24);
        NbaPlayer p2 = new NbaPlayer("james", 23);
        NbaPlayer p3 = new NbaPlayer("harden", 1);
        List<NbaPlayer> list = Stream.of(p1, p2, p3).collect(Collectors.toList());

        List<NbaPlayer> ret = list.stream().filter(nbaPlayer -> nbaPlayer.getNum() > 23).collect(Collectors.toList());
        ret.forEach(v -> System.out.println(v.getName()));
    }

    private static void flatMap() {
        List<String> list = Stream.of("A", "B", "C").collect(Collectors.toList());
        System.out.println(list);

        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");

        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);
        playersInWorldCup2016.add(teamNewZeland);
        playersInWorldCup2016.add(teamSouthAfrica);
        playersInWorldCup2016.add(teamWestIndies);
        playersInWorldCup2016.add(teamSriLanka);
        playersInWorldCup2016.add(teamPakistan);

        // Let's print all players before Java 8
        List<String> listOfAllPlayers = new ArrayList<>();

        for (List<String> team : playersInWorldCup2016) {
            for (String name : team) {
                listOfAllPlayers.add(name);
            }
        }

        System.out.println("Players playing in world cup 2016");
        System.out.println(listOfAllPlayers);

        // Now let's do this in Java 8 using FlatMap
        List<String> flatMapList = playersInWorldCup2016.stream()
            .flatMap(pList -> pList.stream())
            .collect(Collectors.toList());

        System.out.println("List of all Players using Java 8");
        System.out.println(flatMapList);
    }
}
