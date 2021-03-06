package DesignPattern.DecoratorPattern.LOLHerosLearnSkills;

/**
 * @author chenmengliang
 * @date 2019/10/17 12:50
 **/
public class SkillE extends Skills {

    public SkillE(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void learnSkill() {
        System.out.println("学习了E技能");
        hero.learnSkill();
    }
}
