package com.tazine.third.joda;

import org.joda.time.DateTime;

/**
 * JodaDateTimeDemo
 *
 * @author frank
 * @date 2018/03/22
 */
public class JodaDateTimeDemo {

    public static void main(String[] args) {

        String s = new DateTime().toString("yyyyMMddhhmmss");
        System.out.println(s);

        String ymd = new DateTime().toString("yyyyMMdd");
        System.out.println(ymd);



    }

}
