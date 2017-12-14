package com.tazine.java8.datetime;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimeZone;

/**
 * Java8-Clock类使用
 *
 * @author Frank
 * @since 1.0.0
 */
public class DateTimeDemo {

    private static Clock clock = Clock.systemUTC();

    private static LocalDate localDate = LocalDate.now();
    private static LocalDate dateFromClock = LocalDate.now(clock);

    private static LocalTime localTime = LocalTime.now();
    private static LocalTime timeFromClock = LocalTime.now(clock);

    public static void main(String[] args) {
        clockDemo();
        localDateDemo();
        localTimeDemo();
    }

    /**
     * 根据 LocalTime 获取当前时间 （时、分、秒）
     * 时间对比
     */
    public static void localTimeDemo() {
        System.out.println(localTime);
        System.out.println(timeFromClock);

        System.out.println();

        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());

        System.out.println();

        LocalTime time1 = LocalTime.now();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime time2 = LocalTime.now();
        System.out.println("time1 = " + time1);
        System.out.println("time2 = " + time2);

        System.out.println("time1.compareTo(time2) : " + time1.compareTo(time2));

    }

    /**
     * 根据 LocalDate 类获取当前日期
     */
    public static void localDateDemo() {
        System.out.println(localDate);
        System.out.println(dateFromClock);
    }

    /**
     * Clock 可替代 System.currentTimeMills() 和 TimeZone.getDefault()
     */
    public static void clockDemo() {
        System.out.println("System.currentTimeMills() : " + System.currentTimeMillis());
        System.out.println("clock.mills() : " + clock.millis());

        System.out.println();

        System.out.println("TimeZone.getDefault() : " + TimeZone.getDefault());
        System.out.println("clock.instant() : " + clock.instant());
    }
}
