package DesignPattern.DecoratorPattern.EatChickenGun;

/**
 * @author chenmengliang
 * @date 2019/10/17 13:11
 *  2. 装上弹匣后有10发子弹；
 **/
public class Magazine extends AbstractMagazine {


    public Magazine(Gun gun) {
        super(gun);
    }

    @Override
    public void fire() {
        System.out.println("砰*10");
        gun.fire();
    }
}
