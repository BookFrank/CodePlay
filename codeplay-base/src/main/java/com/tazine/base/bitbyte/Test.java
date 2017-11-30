package com.tazine.base.bitbyte;

/**
 * Created by lina on 2017/11/30.
 */
public class Test {


    public static void main(String[] args) {


//        byte a = (byte) 127;
//        byte b = (byte) 128;
//        byte c = (byte) 100;
//        int x = 0xff;//255
//        byte d = (byte) x;
//        x = 0x80;//128
//        byte f = (byte) x;
//        c = (byte) (c * 3);
//        System.out.println(a + " " + b + " " + c + " " + d + " " + f);

        byte a = (byte) 128;
        byte b = (byte) 129;
        byte[] ab = new byte[]{(byte) 65};

        System.out.println(a + " " + b); // -128  -127

        System.out.println(String.valueOf(a)); // -128

        System.out.println(new String(ab));

        byte[] e = "A".getBytes();
        for (byte s : e){
            System.out.println(s);
        }


    }


}
