package com.tazine.third.commons;

import org.apache.commons.lang3.StringUtils;

/**
 * CommonsDemo
 *
 * @author frank
 * @date 2018/03/07
 */
public class CommonsDemo {

    public static void main(String[] args) {

        String nullStr = null;
        String emptyStr = "";

        System.out.println(StringUtils.isNotEmpty(nullStr));
        System.out.println(StringUtils.isNotEmpty(emptyStr));

        System.out.println(StringUtils.isEmpty(nullStr));
        System.out.println(StringUtils.isEmpty(emptyStr));
    }

}
