package com.tazine.base.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lina on 2017/12/15.
 */
public class ClassDemo {

    public static void main(String[] args) {

        ArrayList<String> a = new ArrayList<>();
        System.out.println(a.getClass().getName());

        HashMap m = new HashMap();
        System.out.println(m.getClass().getName());

    }
}
