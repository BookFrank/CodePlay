package com.tazine.container.collection.set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by lina on 2018/1/11.
 *
 * @author frank
 * @since 1.0.0
 */
public class HashSetFeatures {

    public static void main(String[] args) {

        /**
         * HashSet 的底层是一个 HashMap，下面这种声明方式采取默认值：
         * 该 set 所能存储的元素个数为 16*0.75=12个，默认是16个桶
         */
        Set<String> strSet = new HashSet<>();

        /**
         * 下面这个Set集合能存放的元素个数最大为 16*2 = 32 个
         */
        Set<String> cSet = new HashSet<>(16,2);

        for (int i = 0 ; i < 20; i++){
            strSet.add(String.valueOf(i));
        }



//
//        Random rand = new Random(47);
//        Set<Integer> set = new HashSet<>();
//
//        for (int i = 0; i < 10000; i++) {
//            set.add(rand.nextInt(30));
//        }
//
//        if (set.contains(20)){
//            System.out.println("底层是 map.contains(key)");
//        }
//
//        System.out.println(set);
    }
}
