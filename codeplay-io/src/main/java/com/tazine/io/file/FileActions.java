package com.tazine.io.file;

import java.io.File;
import java.net.MalformedURLException;

/**
 * File 方法
 *
 * @author frank
 * @since 1.0.0
 */
public class FileActions {

    public static void main(String[] args) throws MalformedURLException {

        File file1 = new File("/Users/lina/codeplay/test");
        File file2 = new File("/Users/lina/codeplay/test/a.txt");

        if (file1.exists() && file2.exists()) {
            if (file1.isDirectory()) {
                System.out.print("file1-文件夹" + "  ");
            } else {
                System.out.print("file1-文件" + "  ");
            }
            if (file2.isDirectory()) {
                System.out.print("file2-文件夹");
            } else {
                System.out.print("file2-文件" + "  ");
            }
            System.out.println();
            System.out.println();

            // getName() 返回文件夹名或文件名
            System.out.println("file1.getName() : " + file1.getName());
            System.out.println("file2.getName() : " + file2.getName());
            System.out.println();

            // getPath() 返回文件夹名或文件名
            System.out.println("file1.getPath() : " + file1.getPath());
            System.out.println("file2.getPath() : " + file2.getPath());
            System.out.println();

            // getAbsolutePath() 返回文件夹名或文件名
            System.out.println("file1.getAbsolutePath() : " + file1.getAbsolutePath());
            System.out.println("file2.getAbsolutePath() : " + file2.getAbsolutePath());
            System.out.println();

            // toURI() 返回文件夹名或文件名（当当前File为文件夹时，URI将以/结尾）
            System.out.println("file1.toURI() : " + file1.toURI());
            System.out.println("file2.toURI() : " + file2.toURI());
            System.out.println();

            // toURI().toURL() 返回文件夹名或文件名（当当前File为文件夹时，URI将以/结尾）
            System.out.println("file1.toURI().toURL() : " + file1.toURI().toURL());
            System.out.println("file2.toURI().toURL() : " + file2.toURI().toURL());
            System.out.println();

            // length() 返回文件夹名或文件名
            System.out.println("file1.length() : " + file1.length());
            System.out.println("file2.length() : " + file2.length());
            System.out.println();

            // getParent() 返回当前文件夹或文件的父级文件夹字符串
            System.out.println("file1.getParent() : " + file1.getParent());
            System.out.println("file2.getParent() : " + file2.getParent());
            System.out.println();

            // getParentFile() 返回此抽象路径名的父路径名的抽象路径名
            File file1Parent = file1.getParentFile();
            File file2Parent = file2.getParentFile();
            System.out.println("file1.getParentFile() : " + file1Parent);
            System.out.println("file2.getParentFile() : " + file2Parent);
            System.out.println();

            // list() 当file为文件夹时，返回当前文件夹下的文件名字符串数组
            String[] names1 = file1.list();
            String[] names2 = file2.list();
            System.out.println("file.list()获取的是文件名字符串：");
            for (String s : names1) {
                System.out.print(s + " ");
            }
            System.out.println();
            if (null != names2) {
                for (String i : names2) {
                    System.out.print(i + " ");
                }
            } else {
                System.out.println("当file问文件时，file.list 返回 null");
            }
            System.out.println();

            // listFiles() 当为文件夹时，返回 File[]
            File[] file1Arr = file1.listFiles();
            File[] file2Arr = file2.listFiles();
            System.out.println("file1.listFiles() : ");
            for (File file : file1Arr) {
                System.out.print(file.getName() + " ");
            }
            System.out.println();
            System.out.println("file2.listFiles() : ");
            if (file2Arr != null) {
                for (File file : file2Arr) {
                    System.out.print(file.getName() + " ");
                }
            } else {
                System.out.print("当 file 为文件时，file.listFiles() 返回 null");
            }
            System.out.println();

            // mkdir() 根据此抽象路径创建目录
            File file3 = new File("/Users/lina/codeplay/test/mk");
            file3.mkdir();
        }
    }
}
