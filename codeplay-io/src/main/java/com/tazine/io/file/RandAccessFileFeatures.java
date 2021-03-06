package com.tazine.io.file;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 *
 * @author frank
 * @date 2017/11/19
 */
public class RandAccessFileFeatures {

    public static void main(String[] args) throws IOException {

        String path = "/Users/lina/rand.txt";
        RandomAccessFile raf = new RandomAccessFile(path, "rw");

        String str = "中国";
        for (byte b : str.getBytes()) {
            System.out.print(b + " " + getBit(b) + "         ");
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

    public static String getBit(byte by) {
        StringBuffer sb = new StringBuffer();
        sb.append((by >> 7) & 0x1)
                .append((by >> 6) & 0x1)
                .append((by >> 5) & 0x1)
                .append((by >> 4) & 0x1)
                .append((by >> 3) & 0x1)
                .append((by >> 2) & 0x1)
                .append((by >> 1) & 0x1)
                .append((by >> 0) & 0x1);
        return sb.toString();
    }
}
