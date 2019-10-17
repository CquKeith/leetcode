package DesignPattern.DecoratorPattern.EatChickenGun;

/**
 * @author chenmengliang
 * @date 2019/10/17 13:18
 **/
public abstract class AbstractAmi4X implements GunWithAim4x {

    protected Gun gun;

    @Override
    public void fire() {
        gun.fire();
    }
}

