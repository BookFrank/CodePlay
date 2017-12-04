package com.tazine.base;

/**
 * Java 类型转换
 *
 * @author Frank
 */
public class TypeConver {

    public static void main(String[] args) {
        TypeConver typeConver = new TypeConver();
        typeConver.autoConv();
    }

    private void autoConv() {
        byte myByte = 127;
        int myInt = 150;
        float myFloat = 3.14f;
        char myChar = 65535;
        double myDouble = 45.46546;

        System.out.println("127 + 3.14 = " + (myByte + myFloat));
        System.out.println("127 * 150 = " + myByte * myInt);
        System.out.println("45.46546 + 65535 = " + (myDouble + myChar));
    }

}
