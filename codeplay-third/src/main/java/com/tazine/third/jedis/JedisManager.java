package com.tazine.third.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * JedisManager
 *
 * @author frank
 * @since 1.0.0
 */
public class JedisManager {

    private static JedisManager instance = new JedisManager();
    private static JedisPool pool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);
        config.setMaxIdle(5);

        pool = new JedisPool(config, "127.0.0.1", 6379);
    }

    public static JedisManager getInstance(){
        return instance;
    }

    public boolean set(String key, String val){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return "OK".equalsIgnoreCase(jedis.set(key,val));
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null != jedis){
                jedis.close();
            }
        }
        return false;
    }
}
