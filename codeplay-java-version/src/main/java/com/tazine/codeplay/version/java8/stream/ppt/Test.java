package com.tazine.codeplay.version.java8.stream.ppt;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author frank
 * @date 2019/05/02
 */
public class Test {

    public static void main(String[] args) {

        List<Integer> numbers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //int total = 0;
        //for (int i : numbers){
        //    if (i % 2 == 0){
        //        total+=i;
        //    }
        //}


        int total = numbers.stream().filter(v -> v % 2 == 0).mapToInt(Integer::intValue).sum();


        System.out.println(total);



    }

}
