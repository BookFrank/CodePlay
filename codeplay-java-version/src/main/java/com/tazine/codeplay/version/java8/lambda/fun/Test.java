package com.tazine.codeplay.version.java8.lambda.fun;

import com.google.common.collect.Lists;
import com.tazine.codeplay.version.NbaPlayer;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by lina on 2019-12-25.
 *
 * @author frank
 * @date 2019-12-25
 */
public class Test {

    public static void main(String[] args) {

        NbaPlayer kobe = new NbaPlayer("kobe", 24);
        NbaPlayer james = new NbaPlayer("james", 23);
        NbaPlayer iveson = new NbaPlayer("james", 23);

        List<Integer> list = Lists.newArrayList(1,2,3,4,5);

        list.stream().map(s -> s + 1).forEach(consumer());
//        list.forEach(consumer());
    }

    public static Consumer<Integer> consumer(){
        Consumer<Integer> consumer = System.out::println;
        return consumer;
    }
}
