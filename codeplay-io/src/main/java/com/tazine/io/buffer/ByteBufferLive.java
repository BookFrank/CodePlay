package com.tazine.io.buffer;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 *
 *
 * @author frank
 * @since 1.0.0
 */
public class ByteBufferLive {

    public static void main(String[] args) throws IOException {

        String path = "/Users/lina/Desktop/ch.txt";

        FileInputStream in = new FileInputStream(path);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int r;
        while ((r = in.read()) != -1){
            buffer.put((byte) r);
        }

        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());

        buffer.flip();
        System.out.println("反转之后...");
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());

        byte[] bytes = new byte[6];
        int i =0;
        while (buffer.hasRemaining()){
            bytes[i] = buffer.get();
            i++;
        }
        System.out.println(new String(bytes));
        buffer.clear();
        in.close();
    }
}
