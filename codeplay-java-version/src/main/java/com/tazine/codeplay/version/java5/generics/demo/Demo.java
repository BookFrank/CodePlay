package com.tazine.codeplay.version.java5.generics.demo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author frank
 * @date 2019/06/10
 */
public class Demo {

    public static void main(String[] args) {
        classTest();
        interfaceTest();
    }

    private static void classTest(){
        MySuperClass<String, String> mySuperClass = new MySuperClass<String, String>() {
            @Override
            public void onSuccess(String s, String s2) {
                System.out.println(s + " - " + s2);
            }
        };

        //getClass().getGenericSuperclass()返回表示此 Class 所表示的实体的直接超类的 Type
        ParameterizedType sType = (ParameterizedType) mySuperClass.getClass().getGenericSuperclass();
        sysoType(sType);
    }

    private static void interfaceTest(){
        MyInterface<String, String> myInterface = new MyInterface<String, String>() {
            @Override
            public void onSuccess(String s, String s2) {
                System.out.println(s + " - " + s2);
            }
        };
        ParameterizedType type = (ParameterizedType) myInterface.getClass().getGenericInterfaces()[0];
        sysoType(type);
    }

    private static void sysoType(ParameterizedType type) {
        /*com.bqt.generic.MySuperClass<com.bqt.generic.Student, java.lang.String>
        class sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
        class com.bqt.generic.Student
        class java.lang.Class
        class java.lang.String
        class java.lang.Class

        com.bqt.generic.MyInterface<com.bqt.generic.Student, java.lang.String>
        class sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
        class com.bqt.generic.Student
        class java.lang.Class
        class java.lang.String
        class java.lang.Class*/
        System.out.println(type + "\n" + type.getClass());
        //返回表示此类型实际类型参数的 Type 对象的数组，泛型的参数可能有多个，我们需要哪个就取哪个
        Type[] targets = type.getActualTypeArguments();
        for (int i = 0; i < targets.length; i++) {
            System.out.println(targets[i] + " - " + targets[i].getClass());
        }
    }

}
