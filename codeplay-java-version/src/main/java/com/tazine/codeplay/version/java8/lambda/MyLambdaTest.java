package com.tazine.codeplay.version.java8.lambda;

/**
 * Java8 - Duration类
 *
 * @author frank
 * @date 2018/09/14
 */
public class MyLambdaTest {

    public static void main(String[] args) {

        LambdaPlayer player = new LambdaPlayer("kobe", 24);

        //player.introduce(v -> {
        //    System.out.println("My name is " + v.getName() + ", and my num is " + v.getNum());
        //});

        //player.introduce(v -> System.out.println("My name is " + v.getName() + ", and my num is " + v.getNum()));
        //player.introduce((v1, v2) -> v.getName());
        player.introduce(new MyLambda<LambdaPlayer>() {
            @Override
            public String desc(LambdaPlayer lambdaPlayer) {
                System.out.println("dsdsdsds");
                return null;
            }
        });

        player.introduce(v -> {
            System.out.println("");
            return v.getName();
        });

        player.introduce(s -> {
            System.out.println("dsdsdsd");
            return "hi";
        });
    }
}
