package com.tazine.container;

import java.util.*;

/**
 * Created by lina on 2018/1/11.
 *
 * @author frank
 * @date 2018/1/11
 */
public class CollectMap {


    public static void main(String[] args) {

        Collection<Integer> c = Arrays.asList(1,2,3,4,5);

        Map<Integer,String> m = new HashMap<>();
        m.put(24, "kobe");
        m.put(23, "james");

        Iterator<Integer> it = c.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();

        Set<Map.Entry<Integer,String>> set = m.entrySet();
        for (Map.Entry<Integer,String> e : set){
            System.out.print(e.getKey() + ":" + e.getValue() + " ");
        }




    }

}
