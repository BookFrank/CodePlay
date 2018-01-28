package com.tazine.algorithm.thinking.hash.cases;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Test
 *
 * @author frank
 * @since 1.0.0
 */
public class Test {

    private static String[] servers = {"北京", "青岛", "上海", "香港"};

    private static final int VIRTUAL_NODE_NUMS = 5;

    private static SortedMap<Integer, String> virtualNodes = new TreeMap<>();

    static {
        for (int i = 0; i<servers.length; i++){
            for (int j=0; j< VIRTUAL_NODE_NUMS; j++){
                String virtualName = servers[i] + "-" + j + "号机房";
                virtualNodes.put(getHash(virtualName),virtualName);
            }
        }
    }

    public static int getHash(String key) {
        if (null == key){return 0;}
        int h;
        return (h = key.hashCode()) & (h >>> 16);
    }

    public static String getServer(String req){
        int hash = getHash(req);
        SortedMap<Integer,String> subMap = virtualNodes.tailMap(hash);
        String ret;
        try {
            Integer i = subMap.firstKey();
            ret = virtualNodes.get(i);
        } catch (Exception e) {
            e.printStackTrace();
            ret = virtualNodes.get(virtualNodes.firstKey());
        }
        return ret;
    }

    public static void main(String[] args) {

        String[] reqs = {"192.168.1.1", "124.251.25.19", "147.21.23.1"};
        for (String s : reqs){
            System.out.println(s + " 发来的请求被路由到 " + getServer(s));
        }

    }
}
