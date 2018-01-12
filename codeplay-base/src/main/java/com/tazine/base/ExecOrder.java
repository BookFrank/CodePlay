package com.tazine.base;

/**
 * Finally
 *
 * @author frank
 * @since 1.0.0
 */
public class ExecOrder {

    public static void main(String[] args) {

        // 即使 return 了，finally 依然会执行
        try {
            System.out.println("Hello World");
            return;
        } catch (Exception e){

        } finally {
            System.out.println("Finally ");
        }

    }
}
