package com.tazine.third.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Guava Cache
 *
 * @author frank
 * @date 2017/08/09
 */
public class GuavaCache {

    private static Cache<String,Integer> cache = CacheBuilder.newBuilder()
            // 设置 cache 的初始大小为 10
            .initialCapacity(10)
            // 设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
            .concurrencyLevel(5)
            // 失效策略：缓存项在创建后，在给定时间内没有被写访问（创建或覆盖），则清除
            .expireAfterWrite(5, TimeUnit.SECONDS)
            // 失效策略：缓存项在创建后，在给定时间内没有被读/写访问，则清除
            .expireAfterAccess(10, TimeUnit.SECONDS)
            .build();

    public static void main(String[] args) {

        cache.put("kobe", 24);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            sc.next();
            System.out.println(cache.getIfPresent("kobe"));
        }
    }
}
