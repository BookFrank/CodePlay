package com.tazine.third.joda;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * JodaDemo
 *
 * @author frank
 * @date 2018/3/23
 */
public class JodaDemo {

    public static void main(String[] args) {
        jdkCase();

        jodaCase();
    }

    private static void jdkCase(){
        // 1. 如何用JDK来表示某个任意时刻，使用JDK来创建一个任意时刻的对象
        // JDK 中表示事件对象有两个 java.util.Calendar 和 java.util.Date
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getDefault());
        calendar.set(1992, Calendar.DECEMBER, 11, 0, 0, 0);
        System.out.println(TimeZone.getDefault());
        System.out.println(calendar.getTime());
        System.out.println();

        // 2. 场景：在上面的日期上加上90天怎么办？
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(sdf.format(calendar.getTime()));

        // 3. 场景：距离任意时刻 45 天之后的某天在下一个月的当前周的最后一天的日期
    }


    private static void jodaCase(){
        // 1. 使用 joda 来表示任意时刻
        DateTime dateTime = new DateTime(1992, 12,11,0,0,0, 0);
        System.out.println(dateTime.toDate());

        // 2. 以 Joda 的方式向某一个瞬间加上 90 天并输出结果
        System.out.println(dateTime.plusDays(90).toString("yyyy-MM-dd HH:mm:ss.SSS"));

        // 3. 场景：距离任意时刻 45 天之后的某天在下一个月的当前周的最后一天的日期
        System.out.println(dateTime.plusDays(45).plusMonths(1).dayOfWeek()
                .withMaximumValue().toString("yyyy-MM-dd HH:mm:ss.SSS"));

        // 4. JDK 与 Joda 的互操作性
        Calendar calendar = Calendar.getInstance();
        System.out.println(dateTime.plusDays(45).plusMonths(1).dayOfWeek()
                .withMaximumValue().toString("E MM/dd/yyyy HH:mm:ss.SSS"));
        calendar.setTime(dateTime.toDate());
    }
}
