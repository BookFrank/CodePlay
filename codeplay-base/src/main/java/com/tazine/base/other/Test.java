package com.tazine.base.other;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created on 2017/11/30.
 */
public class Test {


    public static void main(String[] args) {


        System.out.println(Charset.defaultCharset());

        String s = "中a";

        for (byte b : s.getBytes()) {
            System.out.print(b + " ");
        }

        System.out.println();

        try {
            for (byte b : s.getBytes("unicode")) {
                System.out.print(b + " ");
            }

            System.out.println();
            System.out.println(new String(s.getBytes("unicode"), "unicode"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }


}
