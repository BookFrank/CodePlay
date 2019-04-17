package com.tazine.design.observer.watch;

/**
 * Test
 *
 * @author frank
 * @date 2017/9/9
 */
public class Test {

    public static void main(String[] args) {
        MyObservable rolex = new RolexWatch();
        MyObserver frank = new Frank();
        MyObserver simon = new Simon();
        rolex.registerObserver(frank);
        rolex.registerObserver(simon);

        for (int i = 0; i < 5; i++) {
            rolex.inform(i + "");
        }
    }
}
