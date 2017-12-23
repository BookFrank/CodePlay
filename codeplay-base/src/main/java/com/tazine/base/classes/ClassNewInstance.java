package com.tazine.base.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lina on 2017/12/23.
 *
 * @author frank
 * @since 1.0.0
 */
public class ClassNewInstance<T> {

    private Class<T> c;

    private List<T> list = new ArrayList<>();

    public ClassNewInstance(Class<T> c) {
        this.c = c;
    }

    public void fill(int i) throws IllegalAccessException, InstantiationException {
        for (int k=0; k<i; k++){
            list.add(c.newInstance());
        }
        System.out.println(list);
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        ClassNewInstance<IntegerCount> cni = new ClassNewInstance<>(IntegerCount.class);

        cni.fill(10);
    }

}

class IntegerCount{
    private static int i;

    private int j = i++;

    public IntegerCount() {
        i++;
    }

    @Override
    public String toString() {
        return String.valueOf(j);
    }
}
