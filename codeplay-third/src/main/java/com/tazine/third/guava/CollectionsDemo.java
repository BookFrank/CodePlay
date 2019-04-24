package com.tazine.third.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

/**
 * CollectionsDemo
 *
 * @author frank
 * @date 2019/03/13
 */
public class CollectionsDemo {

    public static void main(String[] args) {

        NbaPlayer james = new NbaPlayer("james", 23, "lakers");
        NbaPlayer kobe = new NbaPlayer("kobe", 24, "lakers");
        NbaPlayer harden = new NbaPlayer("harden", 1, "rockets");
        NbaPlayer wade = new NbaPlayer("wade", 3, "heat");

        List<NbaPlayer> list = Lists.newArrayList(james, kobe, harden, wade);

        // List 的切分
        List<List<NbaPlayer>> lists = Lists.partition(list, 3);
        lists.forEach(v -> {
            System.out.println(JSON.toJSONString(v));
        });

        Collection<NbaPlayer> c = Collections2.filter(list, new Predicate<NbaPlayer>() {
            @Override
            public boolean apply(NbaPlayer nbaPlayer) {
                return nbaPlayer.getNum() > 20;
            }
        });

        List<NbaPlayer> ret = Lists.newArrayList(c);
        ret.forEach(v -> {
            System.out.println(v.getName() + " - " + v.getNum());
        });
    }
}
