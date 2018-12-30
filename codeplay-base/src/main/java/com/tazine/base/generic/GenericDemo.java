package com.tazine.base.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 为什么需要泛型 & 泛型的特性
 *
 * @author Frank
 * @date 2017/12/27
 */
public class GenericDemo {

    public static void main(String[] args) {

        genericAttr();
    }

    /**
     * 泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
     */
    public static void genericAttr(){

        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        Class stringClz = stringList.getClass();
        Class integerClz = integerList.getClass();

        System.out.println(stringClz.getName());
        System.out.println(integerClz.getName());

        if (stringClz.equals(integerClz)){
            System.out.println("List<String> 与 List<Integer> 的类类型相同");
        }

    }

    public static void whyGeneric(){
        List arrayList = new ArrayList();
        arrayList.add("Frank");
        arrayList.add(183);

        for (int i = 0; i < arrayList.size(); i++) {
            String item = (String) arrayList.get(i);
            System.out.println(item);
        }

        List<String> list = new ArrayList<String>();
        list.add("Frank");
        // list.add(183);
        // 使用泛型后，编译器在编译阶段就会帮我们解决这个问题

        for (int i = 0; i < list.size(); i++) {
            String item = (String) list.get(i);
            System.out.println(item);
        }
    }

}
