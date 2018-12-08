package com.tazine.codeplay.version.java8.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * Java8 - Duration类
 *
 * @author Frank
 * @since 1.0.0
 */
public class DurationDemo {

    public static void main(String[] args) {

        LocalDateTime from = LocalDateTime.of(1992, Month.JANUARY, 15, 0, 0, 0);
        LocalDateTime to = LocalDateTime.now();

        Duration duration = Duration.between(from, to);

        System.out.println("Duration in days : " + duration.toDays());
        System.out.println("Duration in hours : " + duration.toHours());
    }
}
