package DesignPattern.DecoratorPattern.LOLHerosLearnSkills;

/**
 * @author chenmengliang
 * @date 2019/10/17 13:01
 **/
public class Client {
    public static void main(String[] args) {
        Hero hero = new BlindMonkHero("Keith");

        hero = new SkillE(hero);
        hero.learnSkill();

        hero = new SkillQ(hero);
        hero.learnSkill();

        hero = new SkillW(hero);
        hero.learnSkill();

    }
}
