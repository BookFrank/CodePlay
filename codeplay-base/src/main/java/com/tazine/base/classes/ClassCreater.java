package com.tazine.base.classes;

/**
 * 创建Class对象引用的三种方式
 *
 * @author frank
 * @date 2017/12/15
 */
public class ClassCreater {

    public static void main(String[] args) {
        // Class.forName() 方式获取Class对象，会进行Class对象的初始化
        try {
            Class c1 = Class.forName("com.tazine.base.classes.Soldier");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 使用类字面常量创建Class对象的引用时，不会自动地初始化该Class对象
        Class c2 = Soldier.class;

        // 使用对象实例获取其Class对象的引用
        Soldier soldier = new Soldier();
        Class c3 = soldier.getClass();

        // 下面的语句会报编译错误，尽管 Integer继承自Number，但是 IntegerClass的对象不是 NumberClass对象的子类
        // Class<Number> numClass = int.class;
        Class<?> intClass = Integer.TYPE;
        intClass = double.class;
        // t通过通配符？使用泛化的Class引用，Class<?> 优于普通的Class

        Class<? extends Number> numClass = int.class;
        numClass = double.class;
        numClass = Number.class;
    }
}

class Soldier{
    static {
        System.out.println("中国人民解放军");
    }

    public static int a = 10;
}
