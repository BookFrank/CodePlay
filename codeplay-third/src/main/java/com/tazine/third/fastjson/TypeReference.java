package com.tazine.third.fastjson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * TypeReference
 *
 * @author frank
 * @date 2018/04/12
 */
public class TypeReference implements ParameterizedType {

    private Type rawType;

    private Type[] actualTypeArguments;

    public TypeReference(Type rawType, Type[] actualTypeArguments) {
        this.rawType = rawType;
        this.actualTypeArguments = actualTypeArguments;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return actualTypeArguments;
    }

    @Override
    public Type getRawType() {
        return rawType;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }

}
