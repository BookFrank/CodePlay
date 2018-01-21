package com.tazine.base.date;

import java.util.Date;

/**
 * DateDemo
 *
 * @author frank
 * @since 1.0.0
 */
public class DateDemo {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println(date.getMonth());
        System.out.println(date.getYear());

        date = new Date(System.currentTimeMillis());
        System.out.println(date);

    }

}
