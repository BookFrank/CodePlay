package com.tazine.base.other;

/**
 * 类初始化顺序
 *
 * @author frank
 * @date 2017/12/03
 */
public class InitOrder extends BaseOrder {

    static {
        System.out.println("init static block");
    }

    {
        System.out.println("init block");
    }

    public InitOrder() {
        System.out.println("init constructor");
    }

    public static void main(String[] args) {
        new InitOrder();
    }
}

class BaseOrder {

    static {
        System.out.println("base static block");
    }

    {
        System.out.println("base block");
    }

    public BaseOrder() {
        System.out.println("base constructor");
    }
}
