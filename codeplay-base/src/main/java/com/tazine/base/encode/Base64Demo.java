package com.tazine.base.encode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;

/**
 * Base64Demo
 *
 * @author frank
 * @date 2019-05-09
 */
public class Base64Demo {

    public static void main(String[] args) throws UnsupportedEncodingException {

        System.out.println(Charset.defaultCharset());
        String name = "frank";
        String name1 = "李frank";

        byte[] b1 = Base64.getEncoder().encode(name.getBytes());
        byte[] b2 = Base64.getEncoder().encode(name.getBytes("GBK"));

        // 当为 frank 时，b1 = b2
        System.out.println(Arrays.toString(b1));
        System.out.println(Arrays.toString(b2));

    }

}
