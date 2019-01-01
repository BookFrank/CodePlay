package com.tazine.third.lombok;

/**
 * LombokTester
 *
 * @author frank
 * @date 2019/01/01
 */
public class LombokTester {

    public static void main(String[] args) {

        NbaPlayer player = new NbaPlayer();
        player.setNum(23);

        System.out.println(player);
    }

}
