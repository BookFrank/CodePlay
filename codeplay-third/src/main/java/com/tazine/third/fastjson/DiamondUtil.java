package com.tazine.third.fastjson;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author frank
 * @date 2018/12/24
 */
public class DiamondUtil {

    public static Type getFieldGeneric(Field field) {
        try {
            Object value = field.get(null);
            Class<?> type = field.getType();
            if (!type.isPrimitive()) {
                Class<?> clz = value.getClass();
                //handle AnonynousClass
                for (; clz.isAnonymousClass(); ) {
                    clz = clz.getSuperclass();
                }
                Type rawType = (Type)clz;
                Type genericType = field.getGenericType();
                try {
                    ParameterizedType parameterizedType = (ParameterizedType)genericType;
                    return new TypeReference(rawType, parameterizedType.getActualTypeArguments());
                } catch (ClassCastException e) {
                    return genericType;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            //log.info("getFieldGeneric Error, {}", JSON.toJSONString(field), e);
        }
        return null;
    }

    public static void main(String[] args) {

        try {
            Field field = ThirdDiamondManager.class.getDeclaredField("player");

            System.out.println(field.getGenericType());
            System.out.println(field.getType());
            System.out.println(field.get(null));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
