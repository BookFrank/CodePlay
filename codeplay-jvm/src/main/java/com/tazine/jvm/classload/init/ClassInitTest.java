package com.tazine.jvm.classload.init;

/**
 * Class Initialization Test
 *
 * @author frank
 * @date 2017/12/12
 */
public class ClassInitTest {

    static {
        // System.out.println(i);
        // 非法向前引用，静态语句块能赋值在其后定义的静态变量，但无法访问
    }

    private static int i = 47;

    public static void main(String[] args) {

        Player[] players = new Player[2];
        // 通过数组定义来引用类，不会触发此类的初始化

        System.out.println(Kobe.gender);
        // 可以发现，通过子类调用父类的静态方法不会触发子类的初始化
        // 对于静态字段，只有直接定义这个字段的类才会被初始化。
        System.out.println();

        Kobe kobe = new Kobe();
        // 输出 Kobe Init，因为在上一步父类已经加载了。
        // 将上一步注释，这里会输出 Player Init...  Kobe Init...
        System.out.println();

        System.out.println(ConstClass.HW);
        // 虽然调用了ConstClass类中的常量，但其实在编译阶段通过常量传播优化，已经将此常量的值存储到了 ClassInitTest 类的
        // 常量池中，以后 ClassInitTest 对常量ConstClass.HW 的引用实际都转化为了对自身常量池的引用
        // 也就是 ClassInitTest 的class文件中没有对 ConstClass 类的符号引用入口，这两个类在编译成Class之后就不存在联系了
        System.out.println();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new DeadLoopClass();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        // 虚拟机会保证一个类的<clinit>() 方法在多线程环境中被正确地加锁、同步，如果多个线程同时去初始化一个类，那么只会有一个
        // 线程去执行这个类的<clinit>() 方法，其他线程都需要阻塞等待，知道活动线程执行<linit>() 方法完毕。


    }
}
