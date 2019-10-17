package DesignPattern.DecoratorPattern.Beverage;

/**
 * @author chenmengliang
 * @date 2019/10/17 10:54
 * 深烘焙的咖啡
 **/
public class DarkRoast implements Beverage{
    @Override
    public double cost() {
        return 10;
    }
}
