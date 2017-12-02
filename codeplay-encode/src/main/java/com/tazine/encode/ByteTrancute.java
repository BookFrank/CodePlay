package com.tazine.encode;

import java.io.UnsupportedEncodingException;

/**
 * Created on 2017/12/1.
 * @author Frank
 */
public class ByteTrancute {


    /**
     * int 类型强制转换为 byte
     */
    private void intToByte(){

        byte a = (byte)127;
        System.out.println("(byte)127 = " + a);
        // =127 因为 byte 类型的取值范围为 -128~127 在这个范围内都可以正常转换

        byte b = (byte)128;
        System.out.println("(byte)128 = " + b);
        // =   因为整型的128的为 00000000 00000000 00000000 10000000，截取低8位为 10000000
        // 因为截取的 10000000 是负数，求原码得 11111111 + 1 = 1 0000 0000 视为 -128

        byte c = (byte)300;
        System.out.println("(byte)300 = " + c);

        byte d = (byte) -300;
        System.out.println("(byte) -300 = " + d);

        int x = 0xff;
        byte e = (byte)0x80;

        System.out.println(a + " " + b + " " + c + " " + d + " " + e);
    }


    public static void main(String[] args) throws UnsupportedEncodingException {

        byte a = 127;
        byte b = (byte)128;
        byte c = (byte) -300;

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
