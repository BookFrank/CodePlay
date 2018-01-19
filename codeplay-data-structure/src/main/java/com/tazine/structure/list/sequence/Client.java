package com.tazine.structure.list.sequence;

/**
 * Created by lina on 2018/1/19.
 *
 * @author frank
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {

        SequentialList<Player> list = new SequentialList<>(10);

        Player p1 = new Player("kobe", "lakers", 24);

        list.add(p1);

        list.print();


    }

}
