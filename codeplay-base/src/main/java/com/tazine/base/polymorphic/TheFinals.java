package com.tazine.base.polymorphic;

/**
 * 多态之向上转型
 *
 * @author Frank
 * @since 1.0.0
 */
public class TheFinals {

    private static void play(NbaPlayer i) {
        i.on();
    }

    public static void main(String[] args) {
        Kobe kobe = new Kobe();
        James james = new James();

        play(kobe);
        play(james);
    }

}

class NbaPlayer {
    void on() {
        System.out.println(this.getClass().getSimpleName() + " 上场比赛");
    }
}

class Kobe extends NbaPlayer {
}

class James extends NbaPlayer {
}