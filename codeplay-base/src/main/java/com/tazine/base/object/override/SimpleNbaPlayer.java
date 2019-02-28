package com.tazine.base.object.override;

import lombok.Getter;
import lombok.Setter;

/**
 * POJO
 *
 * @author jiaer.ly
 * @date 2018/02/28
 */
//@Getter
//@Setter
public class SimpleNbaPlayer {

    private String name;

    public SimpleNbaPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
