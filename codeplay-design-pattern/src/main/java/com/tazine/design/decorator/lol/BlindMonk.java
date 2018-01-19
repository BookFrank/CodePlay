package com.tazine.design.decorator.lol;

/**
 * ConcreteComponent: BlindMonk
 *
 * @author frank
 * @since 1.0.0
 */
public class BlindMonk extends Hero {

    private String name;

    public BlindMonk(String name) {
        this.name = name;
    }

    @Override
    public void learnSkill() {
        System.out.println(name + " 学习了以上技能");
    }
}
