package com.tazine.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * POJO Player
 *
 * @author jiaer.ly
 * @date 2018/12/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    private String name;
    private int num;
}
