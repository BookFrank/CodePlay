package com.tazine.encode.datetype;

import java.io.*;
import java.nio.charset.Charset;

/**
 * byte 相关
 *
 * @author Frank
 * @since 1.0.0
 */
public class CoolByte {

    public static void main(String[] args) {
        CoolByte coolByte = new CoolByte();
        coolByte.fileBytes();
    }

    /**
     * 从文件和String.getBytes()获得到的字节对比
     */
    private void fileBytes() {
        System.out.println("当前系统编码为：" + Charset.defaultCharset());
        try {
            File file = new File("/Users/lina/demo.txt");

            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write("中".getBytes());
            outputStream.close();

            FileInputStream inputStream = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            System.out.println("从文件中读取到3个字节，字节转为int为：");
            while (inputStream.available() > 0) {
                System.out.print("  " + inputStream.read());
            }
            System.out.println();

            String a = "中";
            System.out.println("\"中\".getBytes()得到的字节转为int数组为：");
            for (byte b : a.getBytes()) {
                System.out.print("  " + String.valueOf(b & 0xff));
            }

            br.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
