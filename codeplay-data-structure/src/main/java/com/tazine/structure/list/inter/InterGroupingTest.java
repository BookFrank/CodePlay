package com.tazine.structure.list.inter;

import java.util.ArrayList;
import java.util.List;

/**
 * 路口分组
 *
 * @author frank
 * @date 2019/06/07
 */
public class InterGroupingTest {

    public static void main(String[] args) {

    }

    private static List<InterPoint> mockData(){
        List<InterPoint> inters = new ArrayList<>();

        // 第一个路口
        InterPoint p1 = InterPoint.builder().interName("A路口").nodeName("Node-A").build();
        InterPoint p2 = InterPoint.builder().interName("A路口").nodeName("Node-B").build();
        InterPoint p3 = InterPoint.builder().interName("A路口").nodeName("Node-C").build();
        InterPoint p4 = InterPoint.builder().interName("A路口").nodeName("Node-D").build();
        

        return inters;
    }
}
