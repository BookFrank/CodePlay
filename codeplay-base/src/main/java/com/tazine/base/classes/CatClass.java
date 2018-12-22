package com.tazine.base.classes;

/**
 * @author frank
 * @date 2017/12/15
 */
public class CatClass extends Animal {

    @Override
    public void eat() {
        System.out.println("Cat eat");
    }

    public static void main(String[] args) {

        try {
            Class<?> c = Class.forName("com.tazine.base.classes.CatClass");

            Animal cat = (Animal) c.newInstance();

            cat.eat();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

class Animal {

    public void eat() {
        System.out.println(this.getClass().getSimpleName() + " eat");
    }

}
