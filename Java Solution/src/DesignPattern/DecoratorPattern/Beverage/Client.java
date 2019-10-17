package DesignPattern.DecoratorPattern.Beverage;

/**
 * @author chenmengliang
 * @date 2019/10/17 11:08
 **/
public class Client {
    public static void main(String[] args) {
        Beverage beverage = new DarkRoast();
        System.out.println(beverage.cost());

        beverage = new MilkCondiment(beverage);
        System.out.println(beverage.cost());

        beverage = new MochaCondiment(beverage);
        System.out.println(beverage.cost());

    }
}
