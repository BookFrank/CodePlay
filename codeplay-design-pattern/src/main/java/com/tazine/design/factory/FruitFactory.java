package com.tazine.design.factory;

/**
 *
 */
public class FruitFactory {

    public static Fruit getFruit(int i){
        if (i == 1){
            return new Apple("Apple");
        }else {
            return new Banana("Banana");
        }
    }
}
