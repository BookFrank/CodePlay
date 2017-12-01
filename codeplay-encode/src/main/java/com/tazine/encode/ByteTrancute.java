package com.tazine.encode;

import java.io.UnsupportedEncodingException;

/**
 * Created on 2017/12/1.
 * @author Frank
 */
public class ByteTrancute {


    public static void main(String[] args) throws UnsupportedEncodingException {

        byte a = 127;
        byte b = (byte)128;
        byte c = (byte)200;

        int x = 0xff;
        byte d = (byte)x;
        byte e = (byte)0x80;

        System.out.println(a + " " + b + " " + c + " " + d + " " + e);
        System.out.println(Integer.toHexString((int) '中'));

        String ab = "中";
        byte[] bs = ab.getBytes("Unicode");
        for (byte bb : bs){
            System.out.print(Integer.toHexString(bb & 0xff) + " ");
        }
    }


}
