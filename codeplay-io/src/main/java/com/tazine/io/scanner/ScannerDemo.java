package com.tazine.io.scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Scanner API
 *
 * @author frank
 * @since 1.0.0
 */
public class ScannerDemo {

    public static void main(String[] args) {

        // Scanner 是一个文本扫描器，可以使用正则表达式来分隔文本，并支持多种输入
        // 最常见的用法是监控控制台输入流，等待用户输入
        fileScan();
    }

    private static void fileScan() {

        try {
            Scanner sc = new Scanner(new FileInputStream("/Users/lina/Desktop/zy.log"));
            sc.useDelimiter("\r");
            while (sc.hasNext()){
                System.out.println(sc.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void strScan() {
        System.out.println("Scanner默认使用空格作为分隔符");
        Scanner sc = new Scanner("A B C");
        while (sc.hasNext()){
            System.out.println(sc.next());
        }

        System.out.println();
        System.out.println("使用 - 作为分隔符");
        Scanner sc1 = new Scanner("1-2-3");
        sc1.useDelimiter("-");
        while (sc1.hasNext()){
            System.out.println(sc1.next());
        }

    }

    public static void input(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(sc.next());
        }
    }
}
