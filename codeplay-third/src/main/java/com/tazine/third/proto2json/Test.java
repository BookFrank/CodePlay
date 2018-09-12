package com.tazine.third.proto2json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author jiaer.ly
 * @date 2018/05/22
 */
public class Test {

    public static void main(String[] args) {

        String s = "[{\"name\":\"kobe\",\"num\":24},{\"name\":\"james\",\"num\":23}]";

        JSONArray array = JSONArray.parseArray(s);

        array.forEach(json -> {
            System.out.println(json.toString());
        });

    }

}
