package com.tazine.base.object;

import lombok.Data;

/**
 * NbaPlayer
 *
 * @author frank
 * @date 2018/02/22
 */
@Data
public class NbaPlayer {

    private String name;

    public NbaPlayer(String name) {
        this.name = name;
    }
}
