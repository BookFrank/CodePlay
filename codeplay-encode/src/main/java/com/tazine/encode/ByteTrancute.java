package com.tazine.encode;

import java.io.UnsupportedEncodingException;

/**
 * byte 类型转换
 *
 * @author Frank
 * @date 2018/05/21
 */
public class ByteTrancute {

    public static void main(String[] args) throws UnsupportedEncodingException {

        ByteTrancute byteTran = new ByteTrancute();

        //byteTran.intToByte();
        //byteTran.byteToInt();
        //byteTran.byteToUnsignedInt();

        byteTran.intDecl();
    }

    /**
     * int类型强制转换为byte
     */
    private void intToByte() {

        byte a = (byte) 127;
        System.out.println("(byte)127 = " + a);
        // =127，因为 byte 类型的取值范围为 -128~127 在这个范围内都可以正常转换

        byte b = (byte) 128;
        System.out.println("(byte)128 = " + b);
        // =-128，因为整型的128的为 00000000 00000000 00000000 10000000，截取补码低8位为 10000000
        // 对截取的补码 10000000求原码得 11111111 + 1 = 1 0000 0000 视为 -128

        byte c = (byte) 300;
        System.out.println("(byte)300 = " + c);
        // =44，int 300的原码（也是补码）为 00000000 00000000 00000001 00101100，截取补码低8位为 00101100
        // 对截取后的补码 00101100求原码，就是其自身

        byte d = (byte) -300;
        System.out.println("(byte) -300 = " + d);
        // =-44，-300的原码和300的原码一致，只是最高位符号位是1，10000000 00000000 00000001 00101100
        // 对-300求补码得 11111111 11111111 11111110 11010011 + 1，截取低八位得 11010100
        // 对截取后的补码 11010100求原码，10101011 + 1 = 10101100，4 + 8 + 32 = 44
    }

    /**
     * byte类型强制转换至int
     * byte为正时前24位补0，为负时前24位补1
     */
    private void byteToInt() {
        byte a = -2;
        int b = (int) a;
        System.out.println("(byte)-2 强转至int = " + b);
        // -2的原码为 10000010，转换为补码得 11111101 + 1 = 11111110
        // 因为是负数，强转至int补1得，11111111 11111111 11111111 11111110
        // 对该补码求原码的 10000000 00000000 00000000 00000001 + 1 = 10000000 00000000 00000000 00000010
    }

    /**
     * 字节类型转无符号的int
     */
    private void byteToUnsignedInt() {
        byte a = 2;
        System.out.println(Integer.toHexString(2));
        System.out.println(Integer.toHexString((int) a));
        System.out.println(Integer.toHexString(2 & 0xff));
        System.out.println(Integer.parseInt("2", 16));
        System.out.println();
        // 正数byte转int没什么好说的，因为直接在其前24位补0，所以值不会发生改变

        byte b = -2;
        System.out.println(Integer.toHexString(-2));
        System.out.println(Integer.toHexString((int) b));
        System.out.println(Integer.toHexString(-2 & 0xff));
        System.out.println(Integer.parseInt("fe", 16));
        // 负数byte转int时，会做位扩展，前24位补了1，
        // Integer.toHexString()时，会直接把内存中的补码直接读出数来，这时就会有问题
        // 举例来说，一个byte类型的-1（即0xff），会被转换成int 类型的-1（即0xffffffff）
        // 因此当byte为负时，将byte转为int时需要进行按位与，将前24位变为0，低8位保持不变
    }

    private void intDecl() throws UnsupportedEncodingException {
        int x = 0xff;
        byte d = (byte) x;
        byte e = (byte) 0x80;

        System.out.println(x + " " + d + " " + 0x80 + " " + e);
        System.out.println(Integer.toHexString((int) '中'));

        String ab = "中";
        byte[] bs = ab.getBytes("Unicode");
        for (byte bb : bs) {
            System.out.print(Integer.toHexString(bb & 0xff) + " ");
        }
    }
}
