package DesignPattern.DecoratorPattern.EatChickenGun;

/**
 * @author chenmengliang
 * @date 2019/10/17 13:24
 **/
public class Telescope4X55 extends AbstractAmi4X {

    public Telescope4X55(Gun gun) {
        this.gun = gun;
    }

    @Override
    public void aim4X() {
        System.out.println("4倍镜超级瞄准已部署");

    }
}
