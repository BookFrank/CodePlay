package com.tazine.codeplay.version.java5.generics;

import com.tazine.codeplay.version.NbaPlayer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author frank
 * @date 2019/05/31
 */
public class SingleGenericImpl<T> extends SingleGeneric<T> {

    Class<T> entityClass;

    public SingleGenericImpl() {

        Class clz = getClass();
        System.err.println("getClass="  + clz);

        Type type = getClass().getGenericSuperclass();
        System.err.println("getClass().getGenericSuperclass()=type="  + type);

        if (type instanceof ParameterizedType){
            Type trueType = ((ParameterizedType)type).getActualTypeArguments()[0];
            System.err.println("trueType1 = " + trueType.getTypeName());
            entityClass = (Class<T>)trueType;
            System.out.println(entityClass);
        }else {
            System.out.println("不是参数化类型");
        }
    }

    public static void main(String[] args) {
        SingleGeneric<NbaPlayer> singleGeneric = new SingleGenericImpl<NbaPlayer>();
    }
}
