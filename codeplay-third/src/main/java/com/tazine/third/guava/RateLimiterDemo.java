package com.tazine.third.guava;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Guava-限流
 */
public class RateLimiterDemo {

    public static void main(String[] args) {

        // 创建一个每秒流量为2的令牌桶
        RateLimiter limiter = RateLimiter.create(2);



    }


}
