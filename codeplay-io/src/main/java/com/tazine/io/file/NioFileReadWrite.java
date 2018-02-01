package com.tazine.io.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 使用 NIO 读写文件
 *
 * @author frank
 * @since 1.0.0
 */
public class NioFileReadWrite {

    static void readNIO(){
        String filePath = "/Users/lina/Desktop/ch.txt";
        FileInputStream fin = null;

        try {
            fin = new FileInputStream(filePath);
            System.out.println(fin.available());
            FileChannel channel = fin.getChannel();

            int capacity = 100;
            ByteBuffer bf = ByteBuffer.allocate(capacity);
            System.out.println("限制是：" + bf.limit() + " 容量是：" + bf.capacity() + " 位置是：" + bf.position());

            int length = -1;
            while ((length = channel.read(bf)) != -1){
                System.out.println("限制是：" + bf.limit() + " 容量是：" + bf.capacity() + " 位置是：" + bf.position());
                /**
                 * 读取完成后，将位置置为0，将limit置为容量，以备下次读入到字节缓冲中，从0开始存储
                 */
                bf.clear();
                byte[] bytes = bf.array();
                System.out.write(bytes, 0 ,length);
                System.out.println();
                System.out.println("限制是：" + bf.limit() + " 容量是：" + bf.capacity() + " 位置是：" + bf.position());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null){
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void writeNIO(){
        String filePath = "/Users/lina/Desktop/out.txt";
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(filePath);
            FileChannel channel = fos.getChannel();

            ByteBuffer bf = Charset.forName("utf-8").encode("永远不要停下脚步");
            System.out.println("限制是：" + bf.limit() + " 容量是：" + bf.capacity() + " 位置是：" + bf.position());

            int length = 0;
            while ((length = channel.write(bf)) != 0){
                System.out.println("写入长度" + length);
                System.out.println("限制是：" + bf.limit() + " 容量是：" + bf.capacity() + " 位置是：" + bf.position());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        readNIO();
        System.out.println();
        writeNIO();
    }

}
