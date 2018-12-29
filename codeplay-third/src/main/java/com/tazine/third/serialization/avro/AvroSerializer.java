package com.tazine.third.serialization.avro;

import com.tazine.third.serialization.ISerializer;

/**
 * AvroSerializer
 *
 * @author frank
 * @date 2018/12/26
 */
public class AvroSerializer implements ISerializer {

    public <T> byte[] serialize(T obj) {
        return new byte[0];
    }

    public <T> T deserialize(byte[] data, Class<T> clz) {
        return null;
    }
}
