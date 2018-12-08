package com.tazine.codeplay.version.java8.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Common Stream Usages
 *
 * @author frank
 * @date 2018/03/14
 */
public class StreamUsages {

    public static void main(String[] args) {

        List<String> list = Stream.of("A", "B", "C").collect(Collectors.toList());
        System.out.println(list);

    }
}
