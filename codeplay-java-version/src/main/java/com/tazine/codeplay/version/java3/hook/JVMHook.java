package com.tazine.codeplay.version.java3.hook;

/**
 * JVM 钩子
 * <p> 在线上Java程序中经常遇到进程挂掉，一些状态没有正确的保存下来，
 * 这时候就需要在JVM关掉的时候 执行一些清理现场的代码，Java中的 ShutdownHook 提供了比较好的方案。<p>
 *
 * @author frank
 * @date 2018/12/19
 */
public class JVMHook {

    /**
     * <p> JDK在1.3之后提供了Java Runtime.addShutdownHook(Thread hook)方法， 可以注册一个JVM关闭的钩子，
     * 钩子在以下几种场景被调用：
     * 1. 程序正常退出
     * 2. 使用 System.exit()
     * 3. 终端使用 Ctrl + C 触发的中断
     * 4. 系统关闭
     * <p>
     */
    private static void registerHook() {
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
