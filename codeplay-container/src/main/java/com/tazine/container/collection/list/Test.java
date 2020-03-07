package com.tazine.container.collection.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jiaer.ly
 * @date 2020/01/07
 */
public class Test {

    public static void main(String[] args) {



        String[] regulation = {"诸葛亮","鲁班","xzcx","貂蝉","吕布"};
        final List<String> regulationOrder = Arrays.asList(regulation);
        String[] ordered = {"nice","貂蝉","诸葛亮","xzcx","吕布","貂蝉","鲁班","诸葛亮","貂蝉","鲁班","诸葛亮","hahahahah","adsad"};
        List<String> orderedList = Arrays.asList(ordered);
        Collections.sort(orderedList, new Comparator<String>()
        {
            public int compare(String o1, String o2)
            {
                int io1 = regulationOrder.indexOf(o1);
                int io2 = regulationOrder.indexOf(o2);
                if(io1 == -1){
                    return 1;
                }
                if(io2 == -1){
                    return -1;
                }
                return io1 - io2;
            }
        });

        System.out.println(orderedList);

    }

}
