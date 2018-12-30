package com.tazine.base.reflect;

import java.lang.reflect.Method;

/**
 * ReflectActions
 *
 * @author frank
 * @date 2017/12/05
 */
public class ReflectActions {

    public static void main(String[] args) {

        try {
            Method round = Math.class.getDeclaredMethod("round", double.class);

            // 调用静态方法时，对象可以传null或者任意对象
            System.out.println(round.invoke(null, new Double(2.7)));
            System.out.println(round.invoke(new Object(), new Double(2.7)));
            System.out.println(round.invoke("123", new Double(2.7)));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
