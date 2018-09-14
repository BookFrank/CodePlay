package com.tazine.java8.lambda;

/**
 * Player
 *
 * @author frank
 * @date 2018/09/14
 */
public class Player {

    private String name;

    private Integer num;

    public Player(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
