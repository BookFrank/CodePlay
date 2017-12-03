package com.tazine.algorithm.sort;

/**
 * 简化版桶排序
 *
 * 桶排序的问题是浪费空间，并且桶排序只能降一维的分数排序，无法维护分数和人的对应关系；
 * 并且无法解决浮点数的排序。
 *
 * @author Frank
 */
public class BucketSort {

    /**
     * 全班有十个人，考试分数出来了，请从大到小和从小到大分别排序
     */

    private static final int[] scores = {
        70, 80, 40, 60, 100, 90, 65, 95, 85, 80, 60
    };


    /**
     * 升序桶排序
     * @param array
     * @return
     */
    public int[] ascBucket(int[] array, int range){

        // 声明全部的桶
        int[] buckets = new int[range];

        for (int i : scores) {
            buckets[i]++;
        }

        for (int j=0; j<buckets.length; j++){
            if (buckets[j] > 0) {
                while (buckets[j]-- != 0) {
                    System.out.println(j);
                }
            }
        }
        return array;
    }

    /**
     * 降序桶排序
     * 与正排序一致，只是输出的时候倒着输出就行
     * @param array
     * @param range
     * @return
     */
    public int[] descBucket(int[] array, int range){

        int[] buckets = new int[range];
        for (int i : array) {
            buckets[i]++;
        }

        for (int i=buckets.length-1; i>=0; i--){
            if (buckets[i] > 0) {
                while (buckets[i]-- != 0) {
                    System.out.println(i);
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();

        bucketSort.ascBucket(scores, 101);
        bucketSort.descBucket(scores, 101);



    }

}
