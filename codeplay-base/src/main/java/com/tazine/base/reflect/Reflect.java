package com.tazine.base.reflect;

import com.tazine.base.operator.BitOperator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created on 2017/12/5.
 *
 * @author frank
 * @date 2017/12/05
 */
public class Reflect {

    public static void main(String[] args) {

        BitOperator bitOperator = new BitOperator();

        Class ref = bitOperator.getClass();

        for (Method method : ref.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        for (Field field : ref.getDeclaredFields()) {
            System.out.println(field.getName());
        }

    }

}
