package com.tazine.base.object.func;

/**
 * ClassTest
 *
 * @author frank
 * @date 2018/03/01
 */
public class ClassTest {

    static {
        System.out.println("hello world");
    }

    public static void main(String[] args) throws Exception {
        loadTest();
    }

    private static void loadTest() throws Exception {
        // 静态代码块在类第一次被加载时执行，没有用到它时，该类不会加载因此也就不会执行静态代码块

        // new 对象时，该类第一次加载，执行静态代码块
        ClassDemo demo = new ClassDemo();
        System.out.println(demo.getClass());

        // 上一步，该类已经被加载过了，因此这步不会执行静态代码块
        ClassDemo demo1 = (ClassDemo)Class.forName("com.tazine.base.object.func.ClassDemo").newInstance();
        System.out.println(demo1.getClass());

    }

    private static void classTest(){
        // 1. 静态代码块并没有执行，因为在编译时 ClassDemo.class 已经加载到内存中
        Class<ClassDemo> c = ClassDemo.class;
        System.out.println(c);
        System.out.println();

        // 2. 使用静态加载类创建对象，全部都会执行
        //Object obj = new ClassDemo();
        //System.out.println(obj.getClass());
        //System.out.println();

        // 3. 使用动态加载类创建对象，全部都会执行
        //Object o = Class.forName("com.tazine.base.object.func.ClassDemo").newInstance().getClass();
        //System.out.println(o.getClass());
        //System.out.println();

        // 无论是通过动态加载类还是静态加载类创建的对象，ClassDemo类都会重新加载到内存中，当调用getClass()方法时，并不会执行任何类的初始化操作

        // 4. Class.forName
        //Class<?> c1 = Class.forName("com.tazine.base.object.func.ClassDemo");
        //System.out.println(c1);
    }

}
