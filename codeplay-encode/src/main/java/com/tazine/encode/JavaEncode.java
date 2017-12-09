package com.tazine.encode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * 探究 JAVA 编码
 *
 * @author Frank
 * @since 1.0.0
 */
public class JavaEncode {

    private final static char[] HEX = "0123456789abcdef".toCharArray();

    /**
     * 查看各个字符集编码长度
     *
     * @throws UnsupportedEncodingException
     */
    private void checkEncodeLength() throws UnsupportedEncodingException {
        // Unicode 编码  4-6-4-6
        System.out.println("L（Unicode）编码字节长度：" + "A".getBytes("Unicode").length);
        System.out.println("LL（Unicode）编码字节长度：" + "AA".getBytes("Unicode").length);
        System.out.println("李（Unicode）编码字节长度：" + "李".getBytes("Unicode").length);
        System.out.println("李李（Unicode）编码字节长度：" + "李李".getBytes("Unicode").length);
        System.out.println();

        // Utf-8 编码 1-2-3-6
        System.out.println("L（UTF-8）编码字节长度：" + "A".getBytes("UTF-8").length);
        System.out.println("LL（UTF-8）编码字节长度：" + "AA".getBytes("UTF-8").length);
        System.out.println("李（UTF-8）编码字节长度：" + "李".getBytes("UTF-8").length);
        System.out.println("李李（UTF-8）编码字节长度：" + "李李".getBytes("UTF-8").length);
        System.out.println();

        // Utf-16 编码 4-6-4-6
        System.out.println("L（UTF-16）编码字节长度：" + "A".getBytes("UTF-16").length);
        System.out.println("LL（UTF-16）编码字节长度：" + "AA".getBytes("UTF-16").length);
        System.out.println("李（UTF-16）编码字节长度：" + "李".getBytes("UTF-16").length);
        System.out.println("李李（UTF-16）编码字节长度：" + "李李".getBytes("UTF-16").length);
        System.out.println();
    }


    public static void main(String[] args) throws UnsupportedEncodingException {

        JavaEncode encode = new JavaEncode();


        // encode.checkEncodeLength();

//        byte[] a = "中国".getBytes("UTF-16");
//
//        for (byte b : a){
//            System.out.println(b);
//        }
//        System.out.println();
//
//        System.out.println((byte) 253);

        byte a = -1;

        //System.out.println(a & 0xFF);

        System.out.println("当前的字符集为：" + Charset.defaultCharset());
        String str = "中";
        String[] encoding = {"Unicode", "UnicodeBig", "UnicodeLittle", "UnicodeBigUnmarked",
                "UnicodeLittleUnmarked", "UTF-16", "UTF-16BE", "UTF-16LE"};

        for (int i = 0; i < encoding.length; i++) {
            System.out.println();
            //System.out.println(Integer.parseInt(bytes2HexString(str.getBytes(encoding[i])),16));
            //System.out.printf("%-22s %s%n", encoding[i], bytes2HexString(str.getBytes(encoding[i])));
        }
        byte[] bs = str.getBytes();
        for (byte b : bs) {
            System.out.println(b & 0xff);
//            System.out.println(bytes2HexString(str.getBytes()));
        }
        String[] aa = new String[]{"e4", "b8", "ad", "e5", "9b", "bd"};
        for (String as : aa) {
            //System.out.println(Integer.parseInt(as,16));
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