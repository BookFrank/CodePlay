package com.tazine.codeplay.version.java5.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author frank
 * @date 2018/12/10
 */
public class CasDemo {

    public static void main(String[] args) {

        AtomicInteger ai = new AtomicInteger();
        System.out.println(ai.get());
        System.out.println(ai.incrementAndGet() % 100);

    }


}
