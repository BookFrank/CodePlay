package com.tazine.base;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String相关实践
 *
 * @author frank
 * @since 1.0.0
 */
public class StringPractice {


    public static void main(String[] args) {


        String s1 = "abc";
        String s2 = "abc";

        System.out.println("s1 == s2 : " + (s1 == s2));  // true == 比较的是内存地址，因为"abc"在方法区的运行时常量池中，且只有一个副本，因此内存地址是一样的。

        // JVM 先根据内容 "abc" 查找对象，没有找到则在heap上创建新对象，并赋值，找到则返回已存在的对象的引用。


        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println("s3 == s4 : " + (s3 == s4)); // false new String创建的对象位于Java Heap，创建的是两个对象。


        String s = "a" + "b" + "c" + "d";
        // 就创建了一个对象，"a" 这些都是常量，对于常量，编译时就直接存储它们的字面值，而不是它们的引用，在编译时就直接将它们的结果提取出来。
        // 在 class 文件中就相当于 String s = "abcde";

        String str = new String("frank");
        // 实际创建了两个String对象，一个是通过new创建在堆中，另一个是通过""创建在常量池中，一个是编译期，一个是运行前。

        String s5 = "abc".intern();
        System.out.println("s1 == s5 : " + (s1 == s5));
        // 运行期间调用String类的intern()方法可以向String Pool中动态添加对象。

        String s6 = "ABCDEFGH";
        System.out.println(s6.substring(3, 5));
        // Java中的substring 是前包括后不包括的。


        String test = "a中a李ddepd";
        ss(test, 9);



    }


    private static void ss(String str, int length){

        try {
            byte[] bytes = str.getBytes("unicode");
            System.out.println("当前数组长度为：" + bytes.length);
            byte[] newBytes = Arrays.copyOf(bytes, length);
            System.out.println("截取后的字符串为：" + new String(newBytes));
            if ((newBytes.length % 2) != 0){
                newBytes = Arrays.copyOf(newBytes, newBytes.length-1);
                System.out.println("截取后的长度为单数，再次截取");
            }

            System.out.println(new String(newBytes, "unicode"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
