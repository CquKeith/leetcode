package DesignPattern.DecoratorPattern.LOLHerosLearnSkills;

/**
 * @author chenmengliang
 * @date 2019/10/17 12:50
 **/
public class SkillQ extends Skills {

    public SkillQ(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void learnSkill() {
        System.out.println("学习了Q技能");
        hero.learnSkill();
    }
}
