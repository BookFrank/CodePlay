package com.tazine.design.strategy.caculator;

/**
 * 具体策略角色
 *
 * @author frank
 * @date 2019/05/23
 */
public class MinusStrategy implements MathStrategy{

    @Override
    public int calc(int n1, int n2) {
        return n1 - n2;
    }
}
