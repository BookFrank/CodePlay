package com.tazine.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * POJO Player
 *
 * @author frank
 * @date 2018/12/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player implements Cloneable{

    private String name;
    private int num;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Player(name, num);
    }
}
