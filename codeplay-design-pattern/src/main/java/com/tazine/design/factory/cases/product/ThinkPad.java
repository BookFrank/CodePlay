package com.tazine.design.factory.cases.product;

/**
 * ThinkPad
 *
 * @author frank
 * @date 2018/1/28
 */
public class ThinkPad implements NoteBook {

    @Override
    public void surf() {
        System.out.println("使用 ThinkPad 上网");
    }
}
