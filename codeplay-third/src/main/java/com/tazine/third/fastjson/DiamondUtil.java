package com.tazine.third.fastjson;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author frank
 * @date 2018/12/24
 */
public class DiamondUtil {

    public static Type getFieldGeneric(Field field) {
        try {
            Object value = field.get(null);
            Class<?> type = field.getType();
            // 如果不是基本数据类型
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
            //Field field = ThirdDiamondManager.class.getDeclaredField("player");
            Field field = ThirdDiamondManager.class.getDeclaredField("map");

            System.out.println(field.getGenericType());
            System.out.println(field.getType());

            // 获得 Field 的值
            System.out.println(field.get(null));

            Type type = getFieldGeneric(field);
            System.out.println(type.getTypeName());

            String s = "{\"num\":24}";
            Map<String,Integer> map = JSON.parseObject(s, type);
            System.out.println(map);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
