package com.tazine.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;

/**
 * 带缓存的 I/O 流
 *
 * @author frank
 * @since 1.0.0
 */
public class BufferStream {

    public static void main(String[] args) {
        System.out.println(Charset.defaultCharset());
        System.out.println((int)'l');
        System.out.println((int)'y');
        System.out.println((int)'中');
        System.out.println((int)'国');
        System.out.println((char)10);

        try {
            FileInputStream inputStream = new FileInputStream("/Users/lina/Desktop/ch.txt");
            while (inputStream.available() > 0){
                System.out.println(inputStream.read());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
