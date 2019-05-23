package com.tazine.design.strategy.caculator;

/**
 * 环境角色
 * <p>
 * 内部持有一个抽象角色的引用，供客户端调用
 * <p/>
 *
 * @author frank
 * @date 2019/05/23
 */
public class MathContext {

    // 持有对具体策略的引用
    private MathStrategy strategy;

    public MathContext(MathStrategy strategy) {
        this.strategy = strategy;
    }

    public int calc(int n1, int n2){
        return strategy.calc(n1, n2);
    }
}
