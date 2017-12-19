package com.tazine.algorithm.topk;

import java.util.*;

/**
 * Top K 算法
 * @author frank
 * @since 1.0.0
 */
public class TopKSort {


    public static void main(String[] args) {

        List<String> queryString = getQueryData();

        Hashtable<String, Integer> freqTable = new Hashtable<>();

        for (String s : queryString) {
            freqTable.put(s, freqTable.containsKey(s) ? freqTable.get(s) + 1 : 1);
        }

        System.out.println(freqTable);

        if (freqTable.contains(3)){
            System.out.println(freqTable);
        }

        for (int i=1; i<freqTable.size(); i++){


        }


    }

    /**
     * 获取所有浏览的URL数据
     *
     * @return
     */
    private static List<String> getQueryData() {
        List<String> queryList = new ArrayList<>();

        queryList.add("www.taizne.com");
        queryList.add("www.taizne.com");
        queryList.add("www.taizne.com");
        queryList.add("www.taizne.com");
        queryList.add("www.taizne.com");
        queryList.add("www.taizne.com");
        queryList.add("www.taizne.com");
        queryList.add("www.taizne.com");
        queryList.add("www.taizne.com");
        queryList.add("www.taizne.com");
        queryList.add("www.taizne.com");
        queryList.add("www.taizne.com");

        queryList.add("www.yiche.com");
        queryList.add("www.yiche.com");
        queryList.add("www.yiche.com");
        queryList.add("www.yiche.com");
        queryList.add("www.yiche.com");
        queryList.add("www.yiche.com");
        queryList.add("www.yiche.com");
        queryList.add("www.yiche.com");
        queryList.add("www.yiche.com");
        queryList.add("www.yiche.com");
        queryList.add("www.yiche.com");

        queryList.add("www.nextev.com");
        queryList.add("www.nextev.com");
        queryList.add("www.nextev.com");
        queryList.add("www.nextev.com");
        queryList.add("www.nextev.com");
        queryList.add("www.nextev.com");
        queryList.add("www.nextev.com");

        queryList.add("www.nio.com");
        queryList.add("www.nio.com");
        queryList.add("www.nio.com");
        queryList.add("www.nio.com");
        queryList.add("www.nio.com");
        queryList.add("www.nio.com");
        queryList.add("www.nio.com");
        queryList.add("www.nio.com");
        queryList.add("www.nio.com");
        queryList.add("www.nio.com");
        queryList.add("www.nio.com");
        queryList.add("www.nio.com");
        queryList.add("www.nio.com");
        queryList.add("www.nio.com");

        queryList.add("www.google.com");
        queryList.add("www.google.com");
        queryList.add("www.google.com");

        queryList.add("www.mi.com");
        queryList.add("www.mi.com");
        queryList.add("www.mi.com");
        queryList.add("www.mi.com");
        return queryList;
    }


}
