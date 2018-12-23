package com.tazine.base.encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;

/**
 * Hello world!
 */
public class App {

    private final static char[] HEX = "0123456789abcdef".toCharArray();

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "中国";
        String[] encoding = { "UTF-16", "UTF-8" };

        for (int i = 0; i < encoding.length; i++) {
            System.out.printf("%-22s %s%n", encoding[i], bytes2HexString(str.getBytes(encoding[i])));
        }


        String str1 = "%e4%b8%ad%e5%9b%bd";
        String str2 = "%fe%ff%4e%2d%56%fd";

        String chiStr = null;
        String chiStr2 = null;
        try {
            chiStr = URLDecoder.decode(str1, "utf-8");
            chiStr2 = URLDecoder.decode(str2, "utf-16");
            System.out.println(chiStr);
            System.out.println(chiStr2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public static String bytes2HexString(byte[] bys) {
        char[] chs = new char[bys.length * 2 + bys.length - 1];
        for (int i = 0, offset = 0; i < bys.length; i++) {
            if (i > 0) {
                chs[offset++] = ' ';
            }
            chs[offset++] = HEX[bys[i] >> 4 & 0xf];
            chs[offset++] = HEX[bys[i] & 0xf];
        }
        return new String(chs);
    }
}
