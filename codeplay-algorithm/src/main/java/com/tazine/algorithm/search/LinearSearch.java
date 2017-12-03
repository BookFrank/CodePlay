package com.tazine.algorithm.search;

/**
 * Created on 2017/06/08.
 *
 * 顺序查找
 *
 * 原理：顺序查找就是按顺序从头到尾依次查找，找到数据就结束，否则就一直查找下去，直到最后一位。
 *
 * @author Frank
 */
public class LinearSearch {

    public int search(int[] array, int target){
        for (int i=0; i<array.length; i++){
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
