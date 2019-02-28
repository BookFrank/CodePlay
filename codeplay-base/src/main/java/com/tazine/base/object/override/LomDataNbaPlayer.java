package com.tazine.base.object.override;

import lombok.Data;

/**
 * NbaPlayer @Data
 *
 * @author jiaer.ly
 * @date 2018/02/28
 */
@Data
public class LomDataNbaPlayer {

    private String name;

    public LomDataNbaPlayer(String name) {
        this.name = name;
    }
}
