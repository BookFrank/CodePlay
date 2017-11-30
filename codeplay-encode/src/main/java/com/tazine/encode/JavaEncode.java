package com.tazine.encode;

import java.io.UnsupportedEncodingException;

/**
 * Created on 2017/11/30.
 * 探究 JAVA 编码
 * @author Frank
 */
public class JavaEncode {

    public static void main(String[] args) {

        try {


            // Unicode 编码  4-6-4-6
            System.out.println("L（Unicode）编码字节长度：" + "A".getBytes("Unicode").length);
            System.out.println("LL（Unicode）编码字节长度：" + "AA".getBytes("Unicode").length);
            System.out.println("李（Unicode）编码字节长度：" + "李".getBytes("Unicode").length);
            System.out.println("李李（Unicode）编码字节长度：" + "李李".getBytes("Unicode").length);
            System.out.println();

            // Utf-8 编码 1-2-3-6
            System.out.println("L（UTF-8）编码字节长度：" + "A".getBytes("UTF-8").length);
            System.out.println("LL（UTF-8）编码字节长度：" + "AA".getBytes("UTF-8").length);
            System.out.println("李（UTF-8）编码字节长度：" + "李".getBytes("UTF-8").length);
            System.out.println("李李（UTF-8）编码字节长度：" + "李李".getBytes("UTF-8").length);
            System.out.println();

            // Utf-16 编码 4-6-4-6
            System.out.println("L（UTF-16）编码字节长度：" + "A".getBytes("UTF-16").length);
            System.out.println("LL（UTF-16）编码字节长度：" + "AA".getBytes("UTF-16").length);
            System.out.println("李（UTF-16）编码字节长度：" + "李".getBytes("UTF-16").length);
            System.out.println("李李（UTF-16）编码字节长度：" + "李李".getBytes("UTF-16").length);
            System.out.println();




        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }




    }



}
