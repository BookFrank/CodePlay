package com.tazine.design.strategy.caculator;

/**
 * Test
 *
 * @author frank
 * @date 2019/05/23
 */
public class Test {

    public static void main(String[] args) {

        AddStrategy addStrategy = new AddStrategy();
        MathContext context = new MathContext(addStrategy);

        int n1 = 3;
        int n2 = 1;

        int total = context.calc(n1, n2);
        System.out.println(total);

        MinusStrategy minusStrategy = new MinusStrategy();
        MathContext context1 = new MathContext(minusStrategy);
        int minus = context1.calc(n1, n2);
        System.out.println(minus);
    }
}
