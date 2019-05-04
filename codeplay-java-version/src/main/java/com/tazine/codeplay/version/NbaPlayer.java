package com.tazine.codeplay.version;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * NbaPlayer
 *
 * @author frank
 * @date 2018/03/19
 */
@Data
@AllArgsConstructor
public class NbaPlayer {

    private String name;

    private int num;

    private String team;

    private String section;

    private Integer age;

    public NbaPlayer(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public NbaPlayer(String name, int num, String team) {
        this.name = name;
        this.num = num;
        this.team = team;
    }
}
