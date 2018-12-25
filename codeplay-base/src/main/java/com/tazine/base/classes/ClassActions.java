package com.tazine.base.classes;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Class类中的所有方法
 *
 * @author frank
 * @date 2017/12/15
 */
public class ClassActions {

    public static void main(String[] args) throws IOException {

        forName();

        // 当前类class文件所在的包目录
        System.out.println(ClassActions.class.getResource(""));
        // class path
        System.out.println(ClassActions.class.getResource("/"));

        // class path
        System.out.println(ClassActions.class.getClassLoader().getResource(""));

        URL url = ClassActions.class.getResource("ClassDemo.class");
        System.out.println(url.getPath());

        Enumeration<URL> urls = ClassActions.class.getClassLoader().getResources("com.tazine.base".replace(".", "/"));
        if (null == urls || !urls.hasMoreElements()) {
            System.out.println("null");
        }
        while (urls.hasMoreElements()) {
            System.out.println(urls.nextElement().getPath());
        }

        System.out.println();
        File file = new File("/usr/local/Cellar/tomcat/8.5.14/libexec/webapps/examples/index.html");
        try {
            System.out.println("URI -- " + file.toURI());
            System.out.println("URL -- " + file.toURI().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Class.forName() 默认初始化
     */
    private static void forName() {
        try {
            // Class.forName("com.tazine.base.classes.ClassUtils");
            Class.forName("com.tazine.base.classes.ClassUtils", false, Thread.currentThread().getContextClassLoader());
            // Class.forName() 默认会为Class进行初始化，初始化Class会执行static代码块和staic变量初始化
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
