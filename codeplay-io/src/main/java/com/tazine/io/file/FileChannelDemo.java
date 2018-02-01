package com.tazine.io.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel Practice
 *
 * @author frank
 * @since 1.0.0
 */
public class FileChannelDemo {

    public static void main(String[] args) throws IOException {

        String path = "/Users/lina/rand.txt";

        RandomAccessFile file = new RandomAccessFile(path, "r");

        FileChannel channel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(47);

        System.out.println("size : " + channel.size());
        System.out.println("position: " + channel.position());
        System.out.println("channel.read() : " + channel.read(buffer));

        System.out.println("size : " + channel.size());
        System.out.println("position: " + channel.position());

//        buffer.flip();

//        byte[] bytes = buffer.array();
//
//        System.out.println(new String(bytes));
//
//        for (byte b : bytes){
//            System.out.print(b + " ");
//        }
//        System.out.println();
//        System.out.println("size : " + channel.size());
//        System.out.println("position: " + channel.position());

        byte[] bs = new byte[6];
        int i = 0;
        while (buffer.hasRemaining()) {
            bs[i] = buffer.get();
            System.out.println("position: " + channel.position());
        }

        for (byte b : bs) {
            System.out.print(b + " ");
        }
        System.out.println(new String(bs));
    }
}
