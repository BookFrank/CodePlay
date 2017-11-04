package com.tazine.basic;

import java.io.UnsupportedEncodingException;

/**
 * Created by lina on 2017/9/11.
 */
public class Unicode {


//    public static







    /*
     * C中，char是一个字节，java采用的是unicode编码，char占两个字节 UTF-16
     */


    public static void main(String[] args) {

        char s = '王';

        String a = "a";

        String t = "王";

        try {
            for (byte b: a.getBytes("UTF-16")){
                System.out.println(b);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println(Integer.toHexString((int) 'a' ));

        int aa = (int) t.toCharArray()[0];

        System.out.println(aa);

        System.out.println(Integer.toHexString(aa));

        System.out.println(t.getBytes());

        try {
            System.out.println("王".getBytes("UTF-16"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


}
