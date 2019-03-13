package com.tazine.third.guava;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * NbaPlayer
 *
 * @author jiaer.ly
 * @date 2019/03/13
 */
@Data
@AllArgsConstructor
public class NbaPlayer {

    private String name;
    private Integer num;
    private String team;
}
