package com.tazine.container.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections 类的方法
 *
 * @author frank
 * @since 1.0.0
 */
public class CollectionsActions {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Collections.addAll(list, 3, 1, 2, 5, 4, 1, 3, 2);
        System.out.println(list);

        // 获取list中最小、最大值
        System.out.println();
        System.out.println("集合中的最小值为：" + Collections.min(list));
        System.out.println("集合中的最大值为：" + Collections.max(list));

        // 二分查找
        System.out.println();
        System.out.println("4 在List中二分查找的位置为：" + Collections.binarySearch(list, 4));
        List<NbaPlayer> players = new ArrayList<NbaPlayer>() {
            {
                add(new NbaPlayer("james", 6));
                add(new NbaPlayer("kobe", 24));
                add(new NbaPlayer("iverson", 3));
                add(new NbaPlayer("oneal", 37));
            }
        };
        System.out.println(players.toString());
        System.out.println("kobe 在队列中的位置为：" + Collections.binarySearch(players, new NbaPlayer("kobe", 24)));
        System.out.println("kobe 在队列中的位置为：" + Collections.binarySearch(players, new NbaPlayer("kobe", 24), new PlayerComparator()));

        // 将集合中的元素顺序打乱（发牌）
        System.out.println();
        Collections.shuffle(list);
        System.out.println(list);

        // frequency 计算某个元素在集合中出现的频率
        System.out.println();
        int freq = Collections.frequency(list, 2);
        System.out.println("2 在集合中出现的频率：" + freq);

        // nCopies() 返回不可变对象
        System.out.println();
        List<String> list1 = Collections.nCopies(5, "www");
        System.out.println(list1);
        // list1.add("ww"); 返回的是不可变对象，无法继续添加


        Collections.sort(list);
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

    }
}
