package DesignPattern.DecoratorPattern.EatChickenGun;

/**
 * @author chenmengliang
 * @date 2019/10/17 13:12
 **/
public class Client {
    public static void main(String[] args) {

        Gun gun = new Kar98K();
        gun.fire();

        System.out.println();

        gun = new Magazine(gun);
        gun.fire();

        System.out.println();

        GunWithAim4x gunWithAim4x = new Telescope4X(gun);
        gunWithAim4x.aim4X();
        gunWithAim4x.fire();

        System.out.println();

        gunWithAim4x = new Telescope4X55(gunWithAim4x);
        gunWithAim4x.aim4X();
        gunWithAim4x.fire();




    }
}
