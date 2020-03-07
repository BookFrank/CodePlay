package com.tazine.third.guava.filter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jiaer.ly
 * @date 2019/10/03
 */
public class BusFilter {

    // 创建布隆过滤器
    private static BloomFilter<byte[]> repeatMsgFilter = BloomFilter.create(Funnels.byteArrayFunnel(), 1000, 0.001);

    private static RateLimiter rateLimiter = RateLimiter.create(10000);

    public static void main(String[] args) {

        if (rateLimiter.tryAcquire()){
            
        }
    }

    //public static void main(String[] args) {
    //
    //    // 1. 模拟收到一条数据
    //    byte[] msg = new byte[10];
    //
    //    // 2. 使用过滤器，判断这个消息30s内是否已经发送过一次：已发送-不作处理，未发送-推送并加入到过滤器中
    //    if (!repeatMsgFilter.mightContain(msg)){
    //        // 2.1 推送消息
    //        msgSender.send(msg);
    //        repeatMsgFilter.put(msg);
    //    }
    //
    //    // 3. 使用 scheduledThreadPool 每隔 30s 将当前过滤器清除，并创建新的过滤器
    //}
}
