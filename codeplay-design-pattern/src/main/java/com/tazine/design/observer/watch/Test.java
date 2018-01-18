package com.tazine.design.observer.watch;

/**
 * Test
 *
 * @author frank
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        Subject rolex = new RolexWatch();
        Observer frank = new Frank();
        Observer simon = new Simon();
        rolex.registerObserver(frank);
        rolex.registerObserver(simon);

        for (int i = 0; i < 5; i++) {
            rolex.inform(i + "");
        }
    }
}
