package com.tazine.third.protostuff;

/**
 * Client
 *
 * @author frank
 * @date 2018/03/01
 */
public class Client {

    public static void main(String[] args) {

        NbaPlayer player = new NbaPlayer("kobe", "lakers", 24, 198);

        byte[] bytes = ProtostuffUtil.serliazer(player);

        NbaPlayer player1 = ProtostuffUtil.deserilizer(bytes, NbaPlayer.class);

        System.out.println(player1.toString());
    }
}
