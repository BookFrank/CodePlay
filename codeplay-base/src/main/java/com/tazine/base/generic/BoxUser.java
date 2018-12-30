package com.tazine.base.generic;

/**
 * 使用GenericBox
 *
 * @author Frank
 * @date 2017/12/27
 */
public class BoxUser {

    public static void main(String[] args) {

        GenericBox<Number> numberBox = new GenericBox<>(100);
        printValue(numberBox);

        GenericBox<Integer> integerBox = new GenericBox<>(10);
        //printValue(integerBox);
        // 即使Integer是Number的子类，但是并不能这样使用
        genericPrintValue(integerBox);

        GenericBox<String> stringBox = new GenericBox<>("NBA");
        System.out.println(stringBox.get());
        // limitGenericPrintValue(stringBox);
        // 通过 ？extends Number 限制泛型类型

    }

    /**
     * 泛型方法
     * @param t
     * @param <T>
     */
    public <T> void genericMethod(T t){
        System.out.println(t.getClass().getName());
    }


    public static void printValue(GenericBox<Number> box){
        System.out.println("The value is "  + box.get());
    }

    /**
     * 不是泛型方法，只是使用了泛型通配符
     * @param box
     */
    public static void genericPrintValue(GenericBox<?> box){
        System.out.println("The value is "  + box.get());
    }

    /**
     * 泛型限制
     * @param box
     */
    public static void limitGenericPrintValue(GenericBox<? extends Number> box){
        System.out.println("The value is "  + box.get());
    }
}
