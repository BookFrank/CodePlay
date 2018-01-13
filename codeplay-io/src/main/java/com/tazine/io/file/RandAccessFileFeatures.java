package com.tazine.io.file;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 *
 * @author frank
 * @since 1.0.0
 */
public class RandAccessFileFeatures {


    public static void main(String[] args) throws IOException {

        String path = "/Users/lina/rand.txt";
        RandomAccessFile raf = new RandomAccessFile(path, "rw");

        String str = "中国";
        for (byte b : str.getBytes()) {
            System.out.print(b + " ");
        }
        System.out.println();
        raf.write(str.getBytes());
        raf.close();

        RandomAccessFile file = new RandomAccessFile(path, "r");

        byte[] bytes = new byte[3];
        byte[] bs = new byte[6];
        file.read(bytes);
//        int a = file.read(bs);
//        System.out.println(a + " ----");
        System.out.println(new String(bytes));

        file.read(bytes);

        System.out.println(bytes.length);
        System.out.println(new String(bytes));
//        System.out.println(new String(bs));
        file.close();


    }


}
