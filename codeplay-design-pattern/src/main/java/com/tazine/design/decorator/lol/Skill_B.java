package com.tazine.design.decorator.lol;

/**
 * ConcreteDecorator: SkillB
 *
 * @author frank
 * @since 1.0.0
 */
public class Skill_B extends Skills {

    public Skill_B(Hero hero) {
        super(hero);
    }

    @Override
    public void learnSkill() {
        skillB();
        super.learnSkill();
    }

    private void skillB() {
        System.out.println("等级升至3级，学会新技能" + Skill_B.class.getSimpleName());
    }
}
