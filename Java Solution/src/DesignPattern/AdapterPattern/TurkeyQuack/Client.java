package DesignPattern.AdapterPattern.TurkeyQuack;

/**
 * @author chenmengliang
 * @date 2019/10/9 21:22
 **/
public class Client {
    public static void main(String[] args) {

        Turkey turkey = new WildTurkey();

        Duck duck = new TurkeyAdapter(turkey);

        duck.quack();
    }
}
