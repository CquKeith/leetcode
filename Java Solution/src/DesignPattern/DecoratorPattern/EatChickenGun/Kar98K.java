package DesignPattern.DecoratorPattern.EatChickenGun;

/**
 * @author chenmengliang
 * @date 2019/10/17 13:08
 * 1. 最原始的98K
 **/
public class Kar98K implements Gun {
    @Override
    public void fire() {
        // 原始的98K有5发子弹
        System.out.println("砰*5");
    }
}
