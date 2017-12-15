package com.tazine.base.polymorphic;

/**
 * 不使用多态是多么的麻烦...
 *
 * @author Frank
 * @since 1.0.0
 */
public class TheFinals2 {

    public static void main(String[] args) {
        Kobe kobe = new Kobe();
        James james = new James();

        play(kobe);
        play(james);
    }

    private static void play(Kobe kobe) {
        kobe.on();
    }

    private static void play(James james) {
        james.on();
    }
}
