package com.tazine.base.generic;

/**
 * 泛型盒子
 *
 * @author Frank
 * @since 1.0.0
 */
public class GenericBox<T> {

    private T t;

    public GenericBox() {
    }

    public GenericBox(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public void put(T t) {
        this.t = t;
    }

    /**
     * 泛型方法：通过泛型类型限制传入参数类型
     * @param v
     * @param <V>
     */
    public <V> void check(V v){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("V:" + v.getClass().getName());
    }

    public static void main(String[] args) {

        GenericBox<String> box1 = new GenericBox<>();
        box1.put("Frank");
        box1.check(10);
        System.out.println(box1.get());
        GenericBox<Integer> box2 = new GenericBox<>();
        box2.put(25);
        System.out.println(box2.get());

        // 泛型类，在使用的时候可以不用传入类型实参,将会自动调整
        GenericBox b1 = new GenericBox(123);
        GenericBox b2 = new GenericBox("CEO");
        GenericBox b3 = new GenericBox(true);

        System.out.println("b1 :" + b1.get());
        System.out.println("b2 :" + b2.get());
        System.out.println("b3 :" + b3.get());

        //
        GenericBox<Number> b = new GenericBox<Number>(10);
        System.out.println("GenericBox<Number> : " + b.get());

    }
}
