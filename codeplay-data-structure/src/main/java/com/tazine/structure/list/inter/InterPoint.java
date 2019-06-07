package com.tazine.structure.list.inter;

import lombok.Builder;
import lombok.Data;

/**
 * 路口Node
 *
 * @author frank
 * @date 2019/06/07
 */
@Data
@Builder
public class InterPoint {

    private String interName;
    private String nodeName;

    private float lat;
    private float lon;

    private InterPoint fNode;
    private InterPoint tNode;
}
