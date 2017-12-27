package com.tazine.base;

import java.lang.reflect.Field;

/**
 * Final
 *
 * @author frank
 * @since 1.0.0
 */
public final class FinalTest {

    private static final String STR = "Hello World";

    public static void main(String[] args) {

        // str = "abc";
        // 上面的语句会报错，因为该成员变量被 final修饰，因此初始化之后无法改变。
        // final 修饰基本数据类型和string时，表示该变量值一旦被赋值就不能再改变

        // final 修饰类，指该类不能被继承，但是可以重新赋值
        FinalTest a = new FinalTest();
        FinalTest b = new FinalTest();
        a = b;

        changeFinalStr();
    }

    /**
     * 通过反射，在不修改String引用的前提下修改String的值
     */
    private static void changeFinalStr() {
        try {
            Field field = STR.getClass().getDeclaredField("value");

            field.setAccessible(true);

            char[] c = (char[]) field.get("Hello World");

            c[5] = '_';

            System.out.println(c);
            System.out.println(STR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
