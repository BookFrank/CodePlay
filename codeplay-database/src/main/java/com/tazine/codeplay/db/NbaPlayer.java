package com.tazine.codeplay.db;

import lombok.Data;

import java.util.Date;

/**
 * NbaPlayer
 *
 * @author frank
 * @date 2017/03/14
 */
@Data
public class NbaPlayer {

    private String name;
    private int num;
    private String team;
    private Date creatTime;
}
