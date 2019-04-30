package com.tazine.codeplay.version.java1.jni;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * HelloWorld
 *
 * @author frank
 * @date 2019-04-27
 */
public class HelloWorld {

    public native void sayHello();

    static {
        String customLibraryPath = "/Users/jiaer.ly/codeplay/github/CodePlay/codeplay-java-version/target/classes";
        try {
            addLibraryDir(customLibraryPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 装载动态链接库
        //System.loadLibrary("HelloWorldImpl");
    }

    public static void addLibraryDir(String libraryPath) throws IOException {
        try {
            Field field = ClassLoader.class.getDeclaredField("usr_paths");
            field.setAccessible(true);
            String[] paths = (String[]) field.get(null);
            for (int i = 0; i < paths.length; i++) {
                if (libraryPath.equals(paths[i])) {
                    return;
                }
            }

            String[] tmp = new String[paths.length + 1];
            System.arraycopy(paths, 0, tmp, 0, paths.length);
            tmp[paths.length] = libraryPath;
            field.set(null, tmp);
        } catch (IllegalAccessException e) {
            throw new IOException(
                "Failedto get permissions to set library path");
        } catch (NoSuchFieldException e) {
            throw new IOException(
                "Failedto get field handle to set library path");
        }
    }

    public static void main(String[] args) {
        // 也可以在这里 loadLibrary
        //System.loadLibrary("HelloWorldImpl");
        System.load("/Users/jiaer.ly/codeplay/github/CodePlay/codeplay-java-version/target/classes/libHelloWorldImpl.jnilib");

        // 默认 Java 程序会将 . 当前根目录加入到 java.library.path 中
        System.out.println(JSON.toJSONString(System.getProperties()));

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
        //System.out.println(System.getenv());
    }

    // 1. 编写带有native声明的方法的java类
    // 2. 使用javac命令编译所编写的java类
    // 3. 
}
