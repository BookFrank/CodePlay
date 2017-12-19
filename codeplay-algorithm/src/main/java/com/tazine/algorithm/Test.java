package com.tazine.algorithm;


import java.util.Arrays;

/**
 *
 */
public class Test {

    public static void main(String[] args) {

        int[] a = {2, 1, 4, 3, 5};

        System.out.println(Arrays.toString(a));
        for(int i=1; i<a.length; i++){

            for (int j=0; j<a.length-i; j++){

                if (a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }

            }

        }

        System.out.println(Arrays.toString(a));

    }

}
