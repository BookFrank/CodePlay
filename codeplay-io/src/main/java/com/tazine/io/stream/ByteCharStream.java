package com.tazine.io.stream;

import java.io.*;
import java.nio.charset.Charset;

/**
 * 流：字节流 & 字符流
 *
 * @author frank
 * @since 1.0.0
 */
public class ByteCharStream {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("当前系统编码为：" + Charset.defaultCharset());
        ByteCharStream stream = new ByteCharStream();

        //stream.byteStream();
        //stream.charStream();
        //stream.bufferStream();
        //stream.testFlush();
        stream.readStream();
    }


    /**
     * InputStream 的 read()
     */
    private void readStream() {

        try {
            FileOutputStream outputStream = new FileOutputStream(new File("/Users/lina/demo.txt"));

            outputStream.write("中".getBytes());
            outputStream.close();

            FileInputStream inputStream = new FileInputStream(new File("/Users/lina/demo.txt"));

            Reader reader = new InputStreamReader(inputStream);

            while (inputStream.available() > 0) {
                System.out.print(inputStream.read() + " ");
            }
            System.out.println(); // 228 184 173

            for (byte b : "中".getBytes()) {
                System.out.print((b & 0xff) + " ");
            }

            byte[] b = new byte[2];
            while (inputStream.available() > 0) {
                /**
                 * 返回的 int 值为读取到的字节总数
                 */
                System.out.println(inputStream.read(b));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 不使用close | flush导致的数据丢失情况
     *
     * @throws FileNotFoundException
     */
    private void testFlush() throws FileNotFoundException {
        File file = new File("/Users/lina/demo.txt");
        PrintWriter pw = new PrintWriter(file);
        String s = "";
        for (int i = 0; i < 2000; i++) {
            s = "我是要写入到记事本文件的内容" + i + "\r\n";
            pw.write(s);
        }
        // pw.close();
        // 如果不调用 flush() 或者 close()，会导致一部分数据被丢弃，文件中的i没有到达1999
    }

    private void bufferStream() {

        try {
            File file = new File("/Users/lina/demo.txt");

            FileOutputStream outputStream = new FileOutputStream(file);

            PrintWriter writer = new PrintWriter(outputStream);

            BufferedOutputStream buffer = new BufferedOutputStream(outputStream);

            buffer.write("中".getBytes());

            buffer.flush(); //

            buffer.close();

            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 字节流
     * 字节流：通过流写入字节、或通过流读出字节
     */
    private void byteStream() {
        try {
            File file = new File("/Users/lina/byte.txt");
            FileOutputStream outputStream = new FileOutputStream(file);

            String a = "中";
            /**
             * 字节流只能写入字节
             */
            outputStream.write(a.getBytes());
            // outputStream.flush(); FileOutputStream继承了flush()方法，但是OutputStream的flush方法什么也没做
            outputStream.close();


            FileInputStream inputStream = new FileInputStream(file);
            System.out.println("从文件中读取到的字节数组转为int[]为：");
            /**
             * avaiable 表示还有多少字节可以读
             */
            while (inputStream.available() > 0) {
                System.out.print("  " + inputStream.read());
            }
            inputStream.close();
            System.out.println();
            System.out.println("\"中\".getBytes()得到的字节转为int数组为：");
            for (byte b : a.getBytes()) {
                System.out.print("  " + String.valueOf(b & 0xff));
            }
            System.out.println();
            if (file.delete()) {
                System.out.println("文件删除成功！");
            } else {
                System.out.println("文件删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流
     * Reader：通过流写入字符、或读出字符
     */
    private void charStream() {
        try {
            File file = new File("/Users/lina/char.txt");
            String a = "中";
            FileOutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write(a);
            //writer.flush();
            writer.close(); // 调用close 方法时会自动触发 flush，因此close和flush只要保证有一个就可以
            outputStream.close();

            FileInputStream inputStream = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(inputStream);

            System.out.println("当前文件的编码为：" + reader.getEncoding());
            System.out.println("从文件中读取到的字符流为：");
            while (reader.ready()) {
                System.out.println("  " + reader.read());
            }
            reader.close();
            inputStream.close();
            System.out.println("从String a = \"中\"读取到的字符流为：");
            for (char c : a.toCharArray()) {
                System.out.println("  " + (int) c);
            }
            if (file.delete()) {
                System.out.println("文件删除成功！");
            } else {
                System.out.println("文件删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
