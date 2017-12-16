package com.tazine.algorithm;

import java.util.HashMap;

/**
 *
 */
public class Test {

    public static void main(String[] args) {


        int[] a = new int[]{3,5,7,2,9};

        int[] bucket = new int[10];

        for (int i : a){
            System.out.print(" " + i);
            bucket[i] = 1;
        }

        System.out.println();
        for (int i = 0;i<bucket.length;i++){
            if (bucket[i] == 1){
                System.out.print(" " + i);
            }
        }

        HashMap aa = new HashMap();

    }

}
