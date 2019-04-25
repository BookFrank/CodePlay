package com.tazine.base.date;

import java.util.Date;

/**
 * @author frank
 * @date 2019/04/25
 */
public class Test {

    public static void main(String[] args) {
        long t = System.currentTimeMillis();

        Date d = new Date(t);
        System.out.println(d);
    }
}
