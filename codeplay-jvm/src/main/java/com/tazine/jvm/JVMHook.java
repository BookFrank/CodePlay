package com.tazine.jvm;

/**
 * JVM 钩子
 *
 * @author frank
 * @date 2018/12/19
 */
public class JVMHook {

    public static void registerHook() {
        System.out.println("The JVM is started");
        /**
         * 钩子其实就是一个线程，在JVM退出时执行相应的逻辑
         */
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                System.out.println("执行JVM Hook业务逻辑");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
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
