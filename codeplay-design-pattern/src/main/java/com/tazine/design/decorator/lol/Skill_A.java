package com.tazine.design.decorator.lol;

/**
 * ConcreteDecorator: SkillA
 *
 * @author frank
 * @since 1.0.0
 */
public class Skill_A extends Skills {

    public Skill_A(Hero hero) {
        super(hero);
    }

    @Override
    public void learnSkill() {
        skillA();
        super.learnSkill();
    }

    private void skillA() {
        System.out.println("技能升至2级，学会" + Skill_A.class.getSimpleName());
    }
}
