package com.tazine.third.fastjson;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * getFieldGeneric
 *
 * @author frank
 * @date 2018/12/24
 */
public class TypeUtil {

    public static Type getFieldGeneric(Field field) {
        if (field.getType().isPrimitive()) {
            return null;
        }
        Object value = null;
        try {
            value = field.get(null);
        } catch (Exception e) {
        }
        Type genericType = field.getGenericType();
        if (null == value) {
            return genericType;
        }
        Class<?> clz = value.getClass();
        for (; clz.isAnonymousClass(); ) {
            clz = clz.getSuperclass();
        }
        Type rawType = (java.lang.reflect.Type) clz;
        try {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            return new TypeReference(rawType, parameterizedType.getActualTypeArguments());
        } catch (ClassCastException e) {
            return genericType;
        }
    }

    public static void main(String[] args) {

        try {
            //Field field = ThirdDiamondManager.class.getDeclaredField("player");
            Field field = ThirdDiamondManager.class.getDeclaredField("map");

            System.out.println("GenericType: " + field.getGenericType());
            System.out.println("Type: " + field.getType());

            // 获得 Field 的值
            System.out.println("Field Get: " + field.get(null));

            Type type = getFieldGeneric(field);
            System.out.println("TypeName: " + type.getTypeName());

            //String s = "{\"num\":24}";
            //Map<String, Integer> map = JSON.parseObject(s, type);
            //System.out.println(map);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
