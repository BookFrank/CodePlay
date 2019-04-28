package com.tazine.codeplay.version.java1.jni;

/**
 * HelloWorld
 *
 * @author frank
 * @date 2019-04-27
 */
public class HelloWorld {

    public native void sayHello();

    static {
        // 装载动态链接库
        System.loadLibrary("HelloWorldImpl");
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }

    // 1. 编写带有native声明的方法的java类
    // 2. 使用javac命令编译所编写的java类
    // 3. 
}
