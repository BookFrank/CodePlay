package com.tazine.base.classes;

/**
 * 查看 class loader 如何工作
 *
 * @author Frank
 * @date 2017/12/15
 */
public class ClassLoaderTest {


    // static 子句，在类第一次被加载时执行。
    // 从输出可以看出 Class对象仅在需要的时候才被加载
    // forName 是 Class类的一个 static成员，所有Class对象都属于这个类。
    public static void main(String[] args) {

        System.out.println("进入 Main 函数：");
        new A();
        System.out.println("new A(), A 对象创建完成");

        try {
            //Class<B> b = (Class<B>) Class.forName("com.tazine.base.classes.B");
            Class<B> b = B.class;
            B bb = b.newInstance();
            bb.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Class.forName(B)，B 对象创建完成");

        new C();
        System.out.println("new C(), C 对象创建完成");
    }

}

class A{
    static {
        System.out.println("Class A 已加载");
    }
}

class B{
    static {
        System.out.println("Class B 已加载");
    }
    void test(){
        System.out.println("B的Class对象执行。");
    }
}

class C{
    static {
        System.out.println("Class C 已加载");
    }
}



