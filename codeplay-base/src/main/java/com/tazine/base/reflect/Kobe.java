package com.tazine.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * 反射
 *
 * @author Frank
 * @since 1.0.0
 */
public class Kobe extends NbaPlayer implements BrandInterface {

    public Kobe(String name, int age) {

    }

    public Kobe() {
    }

    public void exec(String str){
        System.out.println("反射传递参数为" + str);
    }

    public static void main(String[] args) {
        Kobe kobe = new Kobe("Kobe", 20);

        Class clz = kobe.getClass(); // 根据JVM中的实例对象获得类

        System.out.println(clz.getPackage());
        System.out.println(clz.getName());
        try {
            Object kobeIns = clz.newInstance();
            Method method = clz.getMethod("exec",String.class);
            method.invoke(kobeIns,"GOAT");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Class superClz = clz.getSuperclass();
        System.out.println(superClz.getPackage());
        System.out.println(superClz.getName());

        System.out.println("接口：");
        Class[] interfaceArr = clz.getInterfaces();
        for (Class c : interfaceArr) {
            System.out.println(c.getName());
        }

        System.out.println("构造器");
        Constructor[] constructors = clz.getConstructors();
        for (Constructor c : constructors) {
            System.out.print(c.getName() + "参数: ");
            for (Type type : c.getGenericParameterTypes()) {
                System.out.print(type.getTypeName() + " ");
            }
            System.out.println();
        }

        Method[] methods = clz.getMethods();

    }
}
