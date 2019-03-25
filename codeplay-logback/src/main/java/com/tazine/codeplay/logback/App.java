package com.tazine.codeplay.logback;

/**
 * Hello world!
 *
 * @author frank
 * @date 2018/12/08
 */
public class App {

    public static void main(String[] args) {

        String s = System.getenv("user.home");
        System.out.println(s);

        System.getenv().forEach((k,v) -> {
            System.out.println(k + "-" + v);
        });
    }
}
