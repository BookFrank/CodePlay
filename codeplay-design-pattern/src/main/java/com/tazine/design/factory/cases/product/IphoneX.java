package com.tazine.design.factory.cases.product;

/**
 * Created by lina on 2018/1/28.
 *
 * @author frank
 * @date 2018/1/28
 */
public class IphoneX implements Phone {
    @Override
    public void call() {
        System.out.println("使用 iPhone X 打电话");
    }
}
