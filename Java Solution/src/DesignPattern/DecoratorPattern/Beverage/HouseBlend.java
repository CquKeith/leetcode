package DesignPattern.DecoratorPattern.Beverage;

/**
 * @author chenmengliang
 * @date 2019/10/17 10:56
 * 混合咖啡
 **/
public class HouseBlend implements Beverage {
    @Override
    public double cost() {
        return 20;
    }
}
