package com.tazine.design.decorator.lol;

/**
 * Decorator: Skills
 *
 * @author frank
 * @since 1.0.0
 */
public class Skills extends Hero {

    protected Hero hero;

    public Skills(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void learnSkill() {
        hero.learnSkill();
    }
}
