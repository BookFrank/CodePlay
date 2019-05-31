package com.tazine.codeplay.version.java5.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 泛型测试
 *
 * @author frank
 * @date 2019/05/31
 */
public class Cont<K, V> {

    private Class<K> entityClass;
    private Class<V> entityClass1;

    public Cont() {
        Class clz = getClass();
        System.err.println("getClass="  + getClass());

        Type type = getClass().getGenericSuperclass();
        System.err.println("getClass().getGenericSuperclass()=type="  + type);

        if (type instanceof ParameterizedType){
            Type trueType = ((ParameterizedType)type).getActualTypeArguments()[0];
            System.err.println("trueType1 = " + trueType.getTypeName());

            trueType = ((ParameterizedType)type).getActualTypeArguments()[1];
            System.err.println("trueType2 = " + trueType.getClass());
        }else {
            System.out.println("不是参数化类型");
        }
    }
}
