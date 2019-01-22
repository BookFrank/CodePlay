package com.tazine.jvm.exception;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * FullGC 问题
 *
 * @author frank
 * @date 2019/01/22
 */
public class FullGCDemo {

    private static ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(50, new ThreadPoolExecutor
        .DiscardOldestPolicy());

    /**
     * 模拟业务：50个线程的线程池，处理从 MQ 过来的天猫订单，采用限流模式，每隔 100ms 处理 100 个订单
     * java -Xms128m -Xmx128m -Xmn64m com.tazine.jvm.exception.FullGCDemo
     *
     * @param args args
     */
    public static void main(String[] args) throws InterruptedException {
        pool.setMaximumPoolSize(50);

        // 每隔 100ms 执行一次业务逻辑
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            processTmallOrders();
            Thread.sleep(100);
        }
    }

    private static void processTmallOrders() {
        List<TmallOrder> tmallOrders = getOrdersFromMQ();
        tmallOrders.forEach(tmallOrder -> {
            pool.scheduleWithFixedDelay(() -> {
                System.out.println("订单处理：id - " + tmallOrder.getProductId());
            }, 2, 3, TimeUnit.SECONDS);
        });
    }

    private static List<TmallOrder> getOrdersFromMQ() {
        List<TmallOrder> orders = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            TmallOrder tmallOrder = TmallOrder.builder()
                .bd1(new BigDecimal(100000000)).bd2(new BigDecimal(100000000)).bd3(new BigDecimal(100000000)).bd4(
                    new BigDecimal(100000000)).bd5(new BigDecimal(100000000)).bd6(new BigDecimal(100000000)).bd7(
                    new BigDecimal(100000000)).bd8(new BigDecimal(100000000)).bd9(new BigDecimal(100000000)).bd10(
                    new BigDecimal(100000000)).bd11(new BigDecimal(100000000)).bd12(new BigDecimal(100000000)).bd13(
                    new BigDecimal(100000000)).bd14(new BigDecimal(100000000)).bd15(new BigDecimal(100000000)).bd16(
                    new BigDecimal(100000000))
                .num(1)
                .payType(2)
                .postType(4)
                .productId(100000000L)
                .userId(231232131223L)
                .sellerId(65623221435L)
                .prodName("iPhoneXS Max")
                .total(2)
                .sellerName("APPLE官方旗舰店")
                .build();
            orders.add(tmallOrder);
        }
        return orders;
    }
}
