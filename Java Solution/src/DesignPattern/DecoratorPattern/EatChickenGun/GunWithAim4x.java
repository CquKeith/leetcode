package DesignPattern.DecoratorPattern.EatChickenGun;

/**
 * @author chenmengliang
 * @date 2019/10/17 13:14
 * 带有4倍镜功能的枪
 * 既有倍镜的功能，又有枪的功能，所以 extends Gun
 **/
public interface GunWithAim4x extends Gun {

    void aim4X();

}
