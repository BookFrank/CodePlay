package com.tazine.base.date;

import java.util.Date;

/**
 * DateDemo
 *
 * @author frank
 * @date 2018/02/28
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
