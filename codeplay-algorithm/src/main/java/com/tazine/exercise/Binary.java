package com.tazine.exercise;

import java.util.Arrays;

/**
 * Created by lina on 2017/10/12.
 */
public class Binary {


    private static int[] arr = {
        87,21,64,24,64,35,84,25,72,14,92,48,73
    };

    public static int biSearch(int[] arr, int target){

        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high){
            mid = (low + high) / 2;

            if (arr[mid] == target){
                return mid;
            }

            if (arr[mid] > target){
                high = mid - 1;
            }

            if (arr[mid] < target){
                low = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        Arrays.sort(arr);

        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
        int a = biSearch(arr, 87);
        System.out.println(a);

    }




}
