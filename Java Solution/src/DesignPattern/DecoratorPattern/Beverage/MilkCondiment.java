package DesignPattern.DecoratorPattern.Beverage;

/**
 * @author chenmengliang
 * @date 2019/10/17 11:03
 **/
public class MilkCondiment extends CondimentDecorator {

    public MilkCondiment(Beverage beverage) {

        this.beverage = beverage;
        this.price = 2;
    }

    @Override
    public double cost() {
        return this.price+beverage.cost();
    }
}
