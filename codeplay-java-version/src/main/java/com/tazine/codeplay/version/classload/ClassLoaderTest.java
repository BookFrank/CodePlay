package com.tazine.codeplay.version.classload;

/**
 * Test
 *
 * @author frank
 * @date 2019/3/24
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

        // 默认编写的程序都是通过 sun.misc.Launcher.AppClassLoader 来加载的
        // sun.misc.Launcher.AppClassLoader 称为应用类加载器，又称系统类加载器。它负责在 JVM 启动时，加载来自在命令 java 中的-classpath 或者 java.class.path 系统属性或者 CLASSPATH 操作系统属性所指定的 JAR 类包和类路径
        ClassLoaderTest test = new ClassLoaderTest();
        ClassLoader cl = test.getClass().getClassLoader();
        System.out.println(cl.getClass().getCanonicalName());

        ClassLoader appCl = ClassLoader.getSystemClassLoader();
        System.out.println("通过ClassLoader.getSystemClassLoader()获取应用类加载器：" + appCl.getClass().getCanonicalName());

    }
}
