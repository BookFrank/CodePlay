package com.tazine.base.generic;

/**
 * 非泛型盒子
 *
 * @author Frank
 * @since 1.0.0
 */
public class SimpleBox {

    private Object object;

    private void put(Object object) {
        this.object = object;
    }

    private Object get() {
        return object;
    }

    public static void main(String[] args) {

        SimpleBox integerBox = new SimpleBox();
        integerBox.put(10);
        Integer a = (Integer) integerBox.get();
        System.out.println(a);

        integerBox.put("12");
        Integer b = (Integer) integerBox.get();
        System.out.println(b);

        // 在代码执行到类型转换时会出现异常，但是编译时不会有任何问题。
    }
}
