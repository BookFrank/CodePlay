package com.tazine.structure.list.sequence;

/**
 * Test
 *
 * @author frank
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {

        SequentialList<Player> list = new SequentialList<>(10);

        Player p1 = new Player("kobe", "lakers", 24);
        Player p2 = new Player("james", "cavs", 23);
        Player p3 = new Player("iverson", "76ers", 3);
        Player p4 = new Player("jordan", "bulls", 23);

        list.add(p1);
        list.add(p2);
        list.add(p3);

        list.insert(1, p4);

        list.print();
    }
}
