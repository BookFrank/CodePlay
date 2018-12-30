package com.tazine.base.generic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.HashMap;
import java.util.Map;

/**
 * 泛型Class<T>
 *
 * @author Frank
 * @date 2017/12/27
 */
public class GenericClz {

    public static void main(String[] args) {

        getPlayerList(NbaPlayer.class);
    }

    static <T> void getPlayerList(Class<T> t) {
        String json = getJsonString();
        Map<String, T> map = JSON.parseObject(json, new TypeReference<Map<String, T>>() {
        });
        T a = map.get("kobe");
        System.out.println(JSON.toJSONString(a));
    }

    static String getJsonString() {
        Map<String, NbaPlayer> playerMap = new HashMap<>();
        NbaPlayer kobe = new NbaPlayer("kobe", 20);
        NbaPlayer james = new NbaPlayer("james", 21);
        playerMap.put("kobe", kobe);
        playerMap.put("james", james);
        return JSON.toJSONString(playerMap);
    }

}
