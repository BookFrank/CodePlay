package com.tazine.design.decorator.lol;

/**
 * LoL Test
 *
 * @author frank
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args) {

        Hero monk = new BlindMonk("盲僧");

        // 循环装饰，增加新功能
        Skills skillA = new Skill_A(monk);
        Skills skillB = new Skill_B(skillA);

        skillB.learnSkill();
    }
}
