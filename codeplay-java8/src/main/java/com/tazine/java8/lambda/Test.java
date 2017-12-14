package com.tazine.java8.lambda;

import java.time.Clock;
import java.util.Arrays;
import java.util.Base64;

/**
 * Created by lina on 2017/12/14.
 */
public class Test {


    public static void main(String[] args) {

        Arrays.asList(1, 2, 3).forEach(System.out::println);

        final Clock clock = Clock.systemUTC();

        System.out.println(clock.instant());

    }
}
