package com.tazine.codeplay.version.java5.generics.base;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author frank
 * @date 2019/06/10
 */
public class Test {

    public static void main(String[] args) {

        Field[] fields = ParameterizedBean.class.getDeclaredFields();
        for (Field f : fields){

            // 所谓参数化类型，指的是其父类是一个带有形参的类型，子类中形参都变成具体的参数了
            Type genericType = f.getGenericType();

            // 是否是 ParameterizedType
            System.out.println(f.getName() + " - " + (f.getGenericType() instanceof ParameterizedType));
            // 从结果来看，具有<>符号的变量是参数化类型

            if (genericType instanceof ParameterizedType){

                // 参数化类型具体参数
                ParameterizedType pType =(ParameterizedType) genericType;
                System.out.print("变量："+pType.getTypeName()+"     ");
                Type[] types =pType.getActualTypeArguments();
                for(Type t:types){
                    System.out.print(" 类型："+t.getTypeName());
                }
                System.out.println();

                // 获取变量的类型
                System.out.print("变量："+f.getName());
                System.out.print(" 变量类型RawType："+pType.getRawType().getTypeName());
                System.out.println();
            }
            System.out.println();
        }
    }
}
