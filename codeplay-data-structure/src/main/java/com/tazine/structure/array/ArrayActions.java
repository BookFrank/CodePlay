package com.tazine.structure.array;

/**
 * ArrayActions
 *
 * @author frank
 * @since 1.0.0
 */
public class ArrayActions {

    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();

        String s = "abcde";
        System.out.println(s.offsetByCodePoints(0,3));
        System.out.println();
    }

    /**
     * 数组具有这种特性：
     * 如果有两个类A和B，如果B继承（extends）了A，那么A[]类型的引用就可以指向B[]类型的对象
     * 测试数组的特殊特性对参数传递的便利性
     */
    private static void test3() {
        String[] a = new String[3];
        doArray(a);
    }

    private static void doArray(Object[] objs) {

    }

    private static void doArray1(Object obj) {
        //不能用Object接收数组，因为这样无法对数组的元素进行访问
        // obj[1]  //错误

        //如果在方法内部对obj转型到数组，存在类型转换异常的风险
        // Object[] objs = (Object[]) obj;
    }

    private static void doArray2(String[] strs) {
        //如果适用特定类型的数组，就限制了类型，失去灵活性和通用性
    }

    private static void doArray3(String name, int age, String id, float account) {
        //如果不适用数组而是依次传递参数，会使参数列表变得冗长，难以阅读
    }

    /**
     * 测试数组的集成关系, 并且他的继承关系是否和数组中元素的类型有关
     */
    private static void test2() {

        //1     在test1()中已经测试得到以下结论: 数组也是对象, 数组的顶层父类是Object, 所以可以向上转型
        int[] a = new int[8];
        Object obj = a; //数组的父类也是Object,可以将a向上转型到Object

        //2     那么能向下转型吗?
        int[] b = (int[]) obj;  //可以进行向下转型

        //3     能使用instanceof关键字判定吗?
        if (obj instanceof int[]) {  //可以用instanceof关键字进行类型判定
            System.out.println("obj的真实类型是int[]");
        }

        //4     下面代码成立吗?
        String[] s = new String[5];
        Object[] obja = s;   //成立,说明可以用Object[]的引用来接收String[]的对象

        //5     那么String[] 的直接父类是Object[] 还是 Object?
        System.out.println(s.getClass().getSuperclass().getName());
        //打印结果为java.lang.Object,说明String[] 的直接父类是 Object而不是Object[]

        //6   下面成立吗?  Father是Son的直接父类
        Son[] sons = new Son[3];
        Father[] fa = sons;  //成立

        //7     那么Son[] 的直接父类是Father[] 还是  Object[] 或者是Object?
        System.out.println(sons.getClass().getSuperclass().getName());
        //打印结果为java.lang.Object,说明Son[]的直接父类是Object

        /**
         * 做一下总结, 如果A是B的父类, 那么A[] 类型的引用可以指向 B[]类型的变量
         * 但是B[]的直接父类是Object, 所有数组的父类都是Object
         */

        //8     上面的结论可以扩展到二维数组
        Son[][] sonss = new Son[2][4];
        Father[][] fathers = sonss;
        //将Father[][]数组看成是一维数组, 这是个数组中的元素为Father[]
        //将Son[][]数组看成是一维数组, 这是个数组中的元素为Son[]
        //因为Father[]类型的引用可以指向Son[]类型的对象
        //所以,根据上面的结论,Father[][]的引用可以指向Son[][]类型的对象

        /**
         * 扩展结论:
         * 因为Object是所有引用类型的父类
         * 所以Object[]的引用可以指向任何引用数据类型的数组的对象. 如:
         * Object[] objs = new String[1];
         * Object[] objs = new Son[1];
         *
         */

        //9     下面的代码成立吗?
        int[] aa = new int[4];
        //Object[] objaa = aa;  //错误的，不能通过编译
        //这是错误的, 因为Object不是int的父类,在这里自动装箱不起作用

        //10    这样可以吗？
        Object[] objss = {"aaa", 1, 2.5};//成立
    }

    /**
     * 测试在java语言中,数组是不是对象
     * 如果是对象, 那么他的类型是什么?
     */
    private static void test1() {
        int[] a = new int[4];
        //a.length;  //对属性的引用不能当成语句
        int len = a.length;  //数组中保存一个字段, 表示数组的长度

        //以下方法说明数组可以调用方法,java中的数组是对象.这些方法是Object中的方法,所以可以肯定,数组的最顶层父类也是Object
        a.clone();
        a.toString();


        /**
         * java是强类型的语言,一个对象总会有一个特定的类型,例如 Person p = new Person();
         * 对象p(确切的说是引用)的类型是Person类, 这个Person类是我们自己编写的
         * 那么数组的类型是什么呢? 下面使用反射的方式进行验证
         */
        int[] a1 = {1, 2, 3, 4};
        System.out.println(a1.getClass().getName());
        //打印出的数组类的名字为[I

        String[] s = new String[2];
        System.out.println(s.getClass().getName());
        //打印出的数组类的名字为  [Ljava.lang.String;

        String[][] ss = new String[2][3];
        System.out.println(ss.getClass().getName());
        //打印出的数组类的名字为    [[Ljava.lang.String;

        /**
         * 所以,数组也是有类型的,只不过这个类型不是有程序员自己定义的类, 也不是jdk里面
         * 的类, 而是虚拟机在运行时专门创建的类
         * 类型的命名规则是:
         *      每一维度用一个[表示;
         *      [后面是数组中元素的类型(包括基本数据类型和引用数据类型)
         *
         * 在java语言层面上,s是数组,也是一个对象,那么他的类型应该是String[],
         * 但是在JVM中,他的类型为[java.lang.String
         *
         * 顺便说一句普通的类在JVM里的类型为 包名+类名, 也就是全限定名
         */
    }

    public static class Father {

    }

    public static class Son extends Father {

    }

}
