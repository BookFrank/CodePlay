package com.tazine.third.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis: 官方首选的 Java 客户端开发包
 *
 * @author frank
 * @date 2018/01/24
 */
public class JedisDemo {

    public static void main(String[] args) {
        jedisSingleton();
        //jedisPool();
    }

    public static void jedisSingleton() {
        // 1. 设置 IP 地址和端口
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.set("frank", "ceo"));
        System.out.println(jedis.get("frank"));

        jedis.close();
    }

    private static void jedisPool() {
        // 获得连接池配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(30);
        // 设置最大空闲连接数
        config.setMaxIdle(10);

        // 获得连接池
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = new JedisPool(config, "127.0.0.1", 6379);
            // 从连接池中获取 jedis 对象
            jedis = pool.getResource();
            jedis.set("frank", "ali");
            System.out.println(jedis.get("frank"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != jedis){
                jedis.close();
            }
            if (null != pool){
                pool.close();
            }
        }
    }
}
