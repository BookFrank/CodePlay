package com.tazine.encode.datatype;

import java.io.UnsupportedEncodingException;

/**
 * char 相关
 *
 * @author Frank
 * @date 2018/05/21
 */
public class CoolChar {

    public static void main(String[] args) throws UnsupportedEncodingException {

        CoolChar coolChar = new CoolChar();

        coolChar.charDisplay();
        coolChar.intToChar();
    }


    /**
     * 0~65536 之间的一个整数唯一对应一个 unicode 字符
     */
    private void intToChar() {
        for (int i = 1; i < 1000; i++) {
            System.out.println((char) i);
        }
    }

    /**
     * char 的两种表示方法
     */
    private void charDisplay() throws UnsupportedEncodingException {

        char a = '\u4e2d';
        char b = '中';
        String c = "中";

        System.out.println("char:");
        System.out.println("   " + a + " 打印为：" + a + ", unicode = " + (int) a + "，对应的16进制数为 " + Integer.toHexString(a));
        System.out.println("   \\u4e2d 打印为 ：" + b + ", unicode = " + (int) b + "，对应的16进制数为 " + Integer.toHexString(b));
        System.out.println("String:");
        System.out.print("   中 字符串的Unicode编码字节数组为：");
        for (byte bt : c.getBytes("Unicode")) {
            System.out.print(Integer.toHexString(bt & 0xff) + " ");
            // byte & 0xff 是将有符号的字节转为无符号的整数
        }
        System.out.println();
        // 可以看出 中 无论是在数据类型char 还是 String 其编码是一致的 （char 默认为 unicode编码）

        char[] charArr = c.toCharArray();
        for (char i : charArr) {
            System.out.println(i);
        }
    }
}
