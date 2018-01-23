package com.tazine.algorithm.thinking;

import java.util.Scanner;

/**
 * 基本算法思想之穷举思想 Brute Force
 * 逻辑是从所有可能的情况中去搜索正确答案：
 *   1. 对于一种可能的情况，计算其结果
 *   2. 满足要求则停止，不满足要求继续执行第一步来计算下一个可能的情况
 *
 * @author frank
 * @since 1.0.0
 */
public class Exhaustion {

    private static int chicken, rabbit;

    public static void main(String[] args) {
        /**
         * 鸡兔同笼问题
         */
        int head, foot;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入头数：");
        head = sc.nextInt();
        System.out.print("请输入脚数：");
        foot = sc.nextInt();
        if (exhaustion(head, foot)) {
            System.out.println("一共有 " + chicken + " 只鸡，" + rabbit + " 只兔。");
        } else {
            System.out.println("无法求解！");
        }
    }

    /**
     * 使用穷举法时需要明确问题的答案的范围
     *
     * @param head 总头数
     * @param foot 总脚数
     */
    private static boolean exhaustion(int head, int foot) {
        int count;
        for (int i = 1; i < head; i++) {
            count = i * 2 + (head - i) * 4;
            if (count == foot) {
                chicken = i;
                rabbit = head - i;
                return true;
            }
        }
        return false;
    }
}
