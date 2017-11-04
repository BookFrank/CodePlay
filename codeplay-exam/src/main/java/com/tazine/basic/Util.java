package com.tazine.basic;

/**
 * Created by lina on 2017/9/11.
 */
public class Util {

    private boolean stringEqual(String str, String anotherStr){
        // char[] anotherArr
        if (str.length() == anotherStr.length()){
            char[] arrA = str.toCharArray();
            char[] arrB = anotherStr.toCharArray();

            int n = str.length();
            while (n-- != 0){
                if (arrA[n] != arrB[n]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 倒序循环 String类的equals()
     */
    private void test(){

        String[] arr = {"l", "y", "y", "c"};

        System.out.println("数组长度为" + arr.length);

//        for (int i = arr.length - 1; i != 0; i--){
//            System.out.println(i);
//        }

        int k = arr.length;
        while (--k != -1){
            System.out.println(k);
        }
        //  --k != 0    相当于 if k
        //
        //
        //
        //

    }


    public static void main(String[] args) {
        Util util = new Util();
        // util.test();

        String a = "abcd";
        String b = "dasdsa";

        int i = a.length();
        while (--i != -1){
            System.out.println(a.toCharArray()[i]);
        }
    }

}
