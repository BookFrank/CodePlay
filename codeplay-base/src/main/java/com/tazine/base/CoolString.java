package com.tazine.base;

/**
 *
 */
public class CoolString {


    public static void main(String[] args) {
        CoolString coolString = new CoolString();

        //coolString.jerque();
        //coolString.sbDelete();
        coolString.xorEncode();
    }


    /**
     * 利用异或加密
     */
    private void xorEncode(){
        String s = "中国";
        char secret = '李';

        System.out.println("原来的字节为：");
        for (byte b : s.getBytes()){
            System.out.print(b + " ");
        }
        byte[] bs = s.getBytes();
        System.out.println("\n加密后字节为：");
        for (int i=0; i<bs.length; i++){
            bs[i] = (byte)(bs[i] ^ (int) secret);
            System.out.print(bs[i] + " ");
        }
        System.out.println("\n加密后字符串为：" + new String(bs));
        System.out.println("\n解密后字节为：");
        for (int i=0; i<bs.length; i++){
            bs[i] = (byte)(bs[i] ^ (int) secret);
            System.out.print(bs[i] + " ");
        }
        System.out.println("\n解密后字符串为：" + new String(bs));

    }

    private void sbDelete(){
        String s = "命运如同海风，度过了时间的海！";
        StringBuilder sb = new StringBuilder(s);
        System.out.println("原来的字符串长度是：" + sb.length());

        // 每个字符和其后的进行比较，如果字符相同将后面的删除
        for (int i=0;i<sb.length();i++){
            for (int j = i + 1; j< sb.length();j++){
                if (sb.charAt(i) == sb.charAt(j)){
                    sb.deleteCharAt(j);
                }
            }
        }
        System.out.println(sb);
    }

    /**
     * 不比不知道，一比吓一跳
     */
    private void jerque() {

        String str = "";
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            str = str + i;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("String 消耗时间：" + (t2 - t1));


        StringBuilder sb = new StringBuilder();
        long t3 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append(i);
        }
        long t4 = System.currentTimeMillis();
        System.out.println("StringBuilder 消耗时间：" + (t4 - t3));
    }


    /*
        比较运算符 "==" 比较的是内存位置，不适宜拿来比较字符串，但整型等可以用 "==" 来比较；
        equals()方法比较的两个字符串内容必须完全一样
     */
    private void strCompare() {
        String s1 = new String("I am a student");
        String s2 = new String("I am a student");
        String s3 = "I am a student";
        String s4 = new String("I AM A STUDENT");
        String s5 = s1;

        boolean b1 = (s1 == s2);
        boolean b2 = (s1 == s3);
        boolean b3 = (s1 == s5);
        boolean b4 = s1.equals(s2);
        boolean b5 = s1.equals(s3);
        boolean b6 = s1.equalsIgnoreCase(s4);

        System.out.println("s1 == s2 " + b1);
        System.out.println("s1 == s3 " + b2);
        System.out.println("s1 == s5 " + b3);
        System.out.println("s1.equals(s2) " + b4);
        System.out.println("s1.equals(s3) " + b5);
        System.out.println("s1.equalsIgnoreCase(s4) " + b6);
    }
}
