package com.tazine.third.serialization;

/**
 * 序列化/反序列化通用接口
 *
 * @author frank
 * @date 2018/12/26
 */
public interface ISerializer {

    /**
     * 序列化
     *
     * @param obj object
     * @param <T> T
     * @return byte[]
     */
    <T> byte[] serialize(T obj);

    /**
     * 反序列化
     *
     * @param data byte[]
     * @param clz  Class
     * @param <T>  Class
     * @return T
     */
    <T> T deserialize(byte[] data, Class<T> clz);
}
