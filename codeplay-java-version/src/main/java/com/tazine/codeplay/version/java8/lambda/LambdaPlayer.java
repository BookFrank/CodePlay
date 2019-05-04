package com.tazine.codeplay.version.java8.lambda;

import lombok.Data;

/**
 * Player
 *
 * @author frank
 * @date 2018/09/14
 */
@Data
public class LambdaPlayer {

    private String name;

    private Integer num;

    public LambdaPlayer(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    public void introduce(MyLambda<? super LambdaPlayer > lambda){
        lambda.desc(this);
    }

}
