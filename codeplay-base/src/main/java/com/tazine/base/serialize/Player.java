package com.tazine.base.serialize;

import lombok.Data;

import java.io.Serializable;

/**
 * Player
 *
 * @author frank
 * @date 2019/04/25
 */
@Data
public class Player implements Serializable {

    private String name;
    private Integer num;
    private String team;

    /**
     * 先按上面的序列化成文件，新加字段后反序列化失败
     */
    private String nation;
}
