package com.tazine.third.fastjson;

import lombok.Data;

/**
 * @author frank
 * @date 2018/12/24
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
