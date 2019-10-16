package DesignPattern.StrategyPattern.DuckQuack;

/**
 * @author chenmengliang
 * @date 2019/10/16 15:28
 **/
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack!");
    }
}
