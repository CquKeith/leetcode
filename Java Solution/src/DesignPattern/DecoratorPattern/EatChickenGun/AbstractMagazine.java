package DesignPattern.DecoratorPattern.EatChickenGun;

/**
 * @author chenmengliang
 * @date 2019/10/17 13:09
 * abstract Decorator 抽象弹夹
 **/
public abstract class AbstractMagazine implements Gun {

    protected Gun gun;

    public AbstractMagazine(Gun gun) {
        this.gun = gun;
    }



}
