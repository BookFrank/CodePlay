package com.tazine.third.serialization.jdk;

import com.tazine.third.serialization.ISerializer;

/**
 * JdkSerializer
 *
 * @author frank
 * @date 2018/12/27
 */
public class JdkSerializer implements ISerializer {

    public <T> byte[] serialize(T obj) {
        return new byte[0];
    }

    public <T> T deserialize(byte[] data, Class<T> clz) {
        return null;
    }
}
