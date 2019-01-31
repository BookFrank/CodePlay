package com.tazine.codeplay.version.java8.lambda;

import lombok.Data;

/**
 * Player
 *
 * @author frank
 * @date 2018/09/14
 */
@Data
public class Player {

    private String name;

    private Integer num;

    public Player(String name, Integer num) {
        this.name = name;
        this.num = num;
    }
}
