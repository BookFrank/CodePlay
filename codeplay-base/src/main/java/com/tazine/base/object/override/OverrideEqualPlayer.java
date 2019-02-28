package com.tazine.base.object.override;

import lombok.Data;

/**
 * OverrideNbaPlayer
 *
 * @author frank
 * @date 2019/02/22
 */
@Data
public class OverrideEqualPlayer {

    private String name;

    public OverrideEqualPlayer(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OverrideEqualPlayer)) {
            return false;
        } else {
            OverrideEqualPlayer player = (OverrideEqualPlayer)o;
            String this$name = this.getName();
            String that$name = player.getName();

            if (null == this$name){
                if (null != that$name){
                    return false;
                }
            }else if (!that$name.equals(this$name)){
                return false;
            }
            return true;
        }
    }
}
