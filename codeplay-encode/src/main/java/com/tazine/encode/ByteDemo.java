package com.tazine.encode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Byte 相关
 */
public class ByteDemo {


    public static void main(String[] args) {

        System.out.println(Charset.defaultCharset());

        String str = "中";
        try {
            for (byte s : str.getBytes("unicode")){
                System.out.print(Integer.toHexString(byte2Int(s)) + " ");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(Integer.toHexString((int) '中'));

    }

    static int byte2Int(byte b){
        return b & 0xff;
    }



}
