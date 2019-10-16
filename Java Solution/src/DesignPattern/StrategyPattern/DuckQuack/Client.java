package DesignPattern.StrategyPattern.DuckQuack;

/**
 * @author chenmengliang
 * @date 2019/10/16 15:33
 **/
public class Client {
    public static void main(String[] args) {
        Duck duck = new Duck();

        duck.performQuack();

        duck.setQuackBehavior(new Quack());
        duck.performQuack();

        duck.setQuackBehavior(new Squeak());
        duck.performQuack();

    }
}
