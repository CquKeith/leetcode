package DesignPattern.DecoratorPattern.LOLHerosLearnSkills;

/**
 * @author chenmengliang
 * @date 2019/10/17 12:33
 * ConcreteComponent
 **/
public class BlindMonkHero implements Hero{

    private String name;


    public BlindMonkHero(String name) {
        this.name = name;
    }

    @Override
    public void learnSkill() {
        System.out.println(name+"学习了以上技能！");
    }
}
