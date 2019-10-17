package DesignPattern.DecoratorPattern.Beverage;

/**
 * @author chenmengliang
 * @date 2019/10/17 10:59
 * 调料装饰者，所有的调料继承他
 **/
public abstract class CondimentDecorator implements Beverage {
    // 该调料是加在那种饮料上的
    // 这里的Beverage和类声明上的implements Beverage不一样
    // 这里使用抽象，表示本demo中的DarkRoast和HouseBlend
    // 实现 Beverage接口，主要是让调料 condiment也具有cost的功能
    protected Beverage beverage;

    // condiment 的单价
    protected double price;

}
