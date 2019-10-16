package DesignPattern.StrategyPattern.DuckQuack;

/**
 * @author chenmengliang
 * @date 2019/10/16 15:30
 **/
public class Squeak implements  QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Squeak!");
    }
}
