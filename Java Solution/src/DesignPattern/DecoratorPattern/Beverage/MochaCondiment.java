package DesignPattern.DecoratorPattern.Beverage;

/**
 * @author chenmengliang
 * @date 2019/10/17 11:05
 **/
public class MochaCondiment extends CondimentDecorator {

    public MochaCondiment(Beverage beverage) {
        this.beverage = beverage;
        this.price = 1;
    }

    @Override
    public double cost() {
        return this.price + beverage.cost();
    }
}
