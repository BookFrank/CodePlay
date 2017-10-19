package com.tazine.synchro;

/**
 * Created by lina on 2017/9/7.
 */
public class Test {


    public static void main(String[] args) {

        Thread01 thread01 = new Thread01();

        new Thread(thread01,"A").start();

        new Thread(thread01,"B").start();

//        new Thread(new Thread01("C")).start();

    }

}
