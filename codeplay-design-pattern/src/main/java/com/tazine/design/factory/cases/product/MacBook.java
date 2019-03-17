package com.tazine.design.factory.cases.product;

/**
 * MacBook
 *
 * @author frank
 * @date 2018/1/28
 */
public class MacBook implements NoteBook {

    @Override
    public void surf() {
        System.out.println("使用 MacBook 上网");
    }
}
