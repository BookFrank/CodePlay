package com.tazine.codeplay.version.jvm;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * JVM 钩子
 * @author frank
 * @date 2018/12/19
 */
public class JVMHook {

    public static void registerHook(){
        System.out.println("The JVM is started");
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("执行JVM Hook业务逻辑");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        registerHook();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
