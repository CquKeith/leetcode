package DesignPattern.AdapterPattern.TurkeyQuack;

/**
 * @author chenmengliang
 * @date 2019/10/9 21:15
 **/
public class WildDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("quack!");
    }
}
