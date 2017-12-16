package com.tazine.base;

/**
 * 类中成员执行顺序
 */
public class ExecOrders {

    public static void main(String[] args) {
        ExecOrder order = new ExecOrder();
        //System.out.println(ExecOrder.i);
    }
}

class ExecOrder {

    static int i = 2;

    static {
        System.out.println("i 的值为 " + i);
        System.out.println("static {} 语句块执行完毕");
        i = 1;
    }

    public ExecOrder() {
        System.out.println("i 的值为 " + i);
        System.out.println("构造方法执行完毕");
    }
}
