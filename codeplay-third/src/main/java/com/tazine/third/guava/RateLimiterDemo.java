package com.tazine.third.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Scanner;

/**
 * Guava-限流
 *
 * @author frank
 * @since 1.0.0
 */
public class RateLimiterDemo {

    public static void main(String[] args) {

        // 创建一个每秒流量为2的令牌桶
        RateLimiter limiter = RateLimiter.create(2);

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            //System.out.println(sc.next());
            System.out.println("-- " + limiter.tryAcquire());
        }
    }
}
