package com.tazine.third.serialization.hessian;

import com.tazine.third.serialization.ISerializer;

/**
 * Created by lina on 2018/12/26.
 *
 * @author frank
 * @date 2018/12/26
 */
public class HessianSerializer implements ISerializer {

    public <T> byte[] serialize(T obj) {
        return new byte[0];
    }

    public <T> T deserialize(byte[] data, Class<T> clz) {
        return null;
    }
}
