package com.tazine.base.operator;

/**
 * 测试对象等价性
 *
 * @author Frank
 * @since 1.0.0
 */
public class EqualOperator {

    public static void main(String[] args) {

        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);

        System.out.println("n1 = n2 : " + (n1 == n2));
        System.out.println("n1 != n2 : " + (n1 != n2));
        System.out.println("n1.equals(n2) :" + n1.equals(n2));

        BitOperator b1 = new BitOperator();
        BitOperator b2 = new BitOperator();
        System.out.println("b1 = b2 : " + (b1 == b2));
        System.out.println("b1 != b2 : " + (b1 != b2));
        System.out.println("b1.equals(b2) :" + b1.equals(b2));

        // 包装类型 Integer String等重写了Object的equals()，比较的其实是值
        // 因此包装类型比较值时应该使用 equals()
        // 自定义类型未重写Object的equals()，因此对比的是引用是否相同。
    }
}
