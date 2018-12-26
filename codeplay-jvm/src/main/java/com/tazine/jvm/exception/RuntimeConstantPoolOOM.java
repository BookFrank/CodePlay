package com.tazine.jvm.exception;

import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize-10M
 * 运行时常量池内存溢出
 *
 * @author frank
 * @date 2017/12/18
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //oom();
        intern();
    }

    private static void intern() {
        String str1 = new StringBuilder("Hello ").append("World").toString();
        String str1_1 = str1.intern();
        System.out.println(str1.intern() == str1_1);
        System.out.println(str1.hashCode() + " " + str1_1.hashCode());
        str1 = "nihao";
        System.out.println(str1 + " " + str1_1);
        System.out.println(str1.hashCode() + " " + str1_1.hashCode());

        String str2 = new StringBuilder("Ja").append("Va").toString();
        System.out.println(str2.intern() == str2);
    }

    private static void oom() {
        // 使用 List 保持着常量池引用，避免 Full GC 回收常量池行为
        List<String> list = new ArrayList<>();

        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
            // 因为创建了太多的String常量，会导致运行时常量池（方法区）异常
        }
    }
}
