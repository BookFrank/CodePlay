package com.tazine.third.lombok;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * NbaPlayer
 *
 * @author frank
 * @date 2019/01/01
 */
@Data
@NoArgsConstructor
public class NbaPlayer {

    @NonNull
    private String name;

    private Integer num;

}
