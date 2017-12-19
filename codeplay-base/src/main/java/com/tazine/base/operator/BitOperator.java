package com.tazine.base.operator;

/**
 * 位运算相关操作 & 相关应用
 *
 * @author Frank
 * @since 1.0.0
 */
public class BitOperator {

    public static void main(String[] args) {
        BitOperator bitOper = new BitOperator();

        bitOper.quickCal();
        bitOper.bitAnd();

        bitOper.bitXor();
        bitOper.bitFlip();
    }


    /**
     * 按位与运算
     */
    private void bitAnd() {
        System.out.println(2 & 10);
        // 0000 0010 & 0000 1010
    }

    /**
     * 按位异或
     * （在进行变量互换时，如果是两个整数类型的变量，可以使用异或运算符进行互换）
     * 当两个操作数的二进制表示相同(同时为0或同时为1)时，结果为0，否则为1
     */
    private void bitXor() {
        int a = 10;
        int b = 8;
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println("a=" + a + " b=" + b);
    }

    /**
     * 移位运算符：如何快速计算 2*8
     */
    private void quickCal() {
        System.out.println(2 << 3);
        // 2*8=2的四次方，将二进制 0000 0010 向左移3位得 0001 0000
    }

    /**
     * 按位取反
     */
    private void bitFlip() {
        System.out.println(~127);
        // 127的二进制补码表示为 0111 1111 = 2的七次方 - 1
        // 按位取反得 1000 0000 ，对其求原码的 1000 0000 = -128
    }
}
