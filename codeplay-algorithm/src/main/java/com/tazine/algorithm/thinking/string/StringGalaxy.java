package com.tazine.algorithm.thinking.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * String 相关
 *
 * @author frank
 * @since 1.0.0
 */
public class StringGalaxy {


    public static void main(String[] args) {

        /**
         * 如何实现字符串的翻转 ？ how are you 转为 you are how
         */
        // 我的解决方案
        String s1 = "how are you";
        swap(s1);
        s1 = mySwap(s1);
        System.out.println(s1);
        StringBuilder sb = new StringBuilder();
        for (String s : s1.split(" ")) {
            sb.append(mySwap(s)).append(" ");
        }
        s1 = sb.toString();
        System.out.println(s1);
        System.out.println();

        /**
         * 如何判断两个字符串是由相同的字符组成
         */
        String s2 = "aabbccddee";
        String s3 = "eeddccbbaa";
        System.out.println(isSame(s2, s3));
        System.out.println(isSame1(s2, s3));
        System.out.println();

        /**
         * 如何删除字符串中重复的字符 ？
         */
        String s4 = "hello world";
        uniqChar(s4);
        System.out.println();

        /**
         * 如何统计一行中有多少单词 ？
         */


        /**
         * 如何输出字符串中的所有组合
         * 问题描述：假设字符串中的所有字符都不重复，如何输出字符串的所有组合 ？
         * 例如，输入字符串 "abc"，则输出 a, b, c, ab, ac, bc, abc 共七种组合
         */
        // 如果字符串中有 n 个字符，根据排列组合的性质，此时一共需要输出 2^n - 1 种组合
        // 最容易想到的方法就是递归法，遍历字符串，每个字符只能取或者不取，若取该字符，就放到结果串中
        String s9 = "abc";
        StringBuffer buffer = new StringBuffer();
        for (int i = 1; i <= s9.length(); i++) {
            recursionStr(s9.toCharArray(), 0, i, buffer);
        }
    }

    private static void recursionStr(char[] chars, int begin, int len, StringBuffer sb) {
        if (len == 0) {
            System.out.print(sb + " ");
            return;
        }
        if (begin == chars.length) {
            return;
        }
        sb.append(chars[begin]);
        recursionStr(chars, begin + 1, len - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        recursionStr(chars, begin + 1, len, sb);
    }

    /**
     * 利用 HashSet 或者 HashMap 来去重
     *
     * @param str
     */
    private static void uniqChar(String str) {
        HashSet<Character> set = new HashSet<>();
        for (Character c : str.toCharArray()) {
            set.add(c);
        }
    }

    private static String mySwap(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        char c;
        for (int i = 0; i < length / 2; i++) {
            c = chars[i];
            chars[i] = chars[length - 1 - i];
            chars[length - 1 - i] = c;
        }
        return new String(chars);
    }

    /**
     * 对整个字符串进行翻转
     *
     * @param str
     * @return
     */
    private static String swap(String str) {
        char[] chars = str.toCharArray();
        int front = 0;
        int end = chars.length - 1;
        char c;
        /**
         * 这种有前后对应关系的可采取前后比较的方式循环
         */
        while (front < end) {
            c = chars[front];
            chars[front] = chars[end];
            chars[end] = c;
            front++;
            end--;
        }
        System.out.println(new String(chars));
        return new String(chars);
    }

    /**
     * 用空间换时间：利用 HashMap 达到统计的目的
     *
     * @param str1
     * @param str2
     * @return
     */
    private static boolean isSame(String str1, String str2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (Character c : str1.toCharArray()) {
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
        }
        for (Character c : str2.toCharArray()) {
            if (map2.containsKey(c)) {
                map2.put(c, map2.get(c) + 1);
            } else {
                map2.put(c, 1);
            }
        }
        if (map1.size() != map2.size()) {
            return false;
        } else {
            Set<Character> set = map1.keySet();
            for (Character c : set) {
                if (!map1.get(c).equals(map2.get(c))) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSame1(String str1, String str2) {
        byte[] bytes1 = str1.getBytes();
        byte[] bytes2 = str2.getBytes();
        Arrays.sort(bytes1);
        Arrays.sort(bytes2);
        System.out.println(new String(bytes1));
        System.out.println(new String(bytes2));
        if (new String(bytes1).equals(new String(bytes2))) {
            return true;
        } else {
            return false;
        }
    }
}
