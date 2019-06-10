package com.tazine.codeplay.version.java5.generics;

import com.tazine.codeplay.version.NbaPlayer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author frank
 * @date 2019/05/31
 */
public class SingleGeneric<T> {

    public SingleGeneric() {
        Class clz = getClass();
        System.err.println("getClass="  + clz);

        Type type = getClass().getGenericSuperclass();
        System.err.println("getClass().getGenericSuperclass()=type="  + type);

        if (type instanceof ParameterizedType){
            Type trueType = ((ParameterizedType)type).getActualTypeArguments()[0];
            System.err.println("trueType1 = " + trueType.getTypeName());
            System.out.println("是参数化类型，" + trueType);
        }else {
            System.out.println("不是参数化类型");
        }
    }

    public static void main(String[] args) {

        //Cont<NbaPlayer, Student> cont1 = new Cont<>();

        SingleGeneric<NbaPlayer> singleGeneric = new SingleGeneric<>();

    }
}
