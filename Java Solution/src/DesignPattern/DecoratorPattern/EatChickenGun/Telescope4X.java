package DesignPattern.DecoratorPattern.EatChickenGun;

/**
 * @author chenmengliang
 * @date 2019/10/17 13:19
 **/
public class Telescope4X extends AbstractAmi4X {


    public Telescope4X(Gun gun) {
        this.gun = gun;
    }

    @Override
    public void aim4X() {
        System.out.println("已进入4倍镜瞄准模式");
    }

}
